package de.thecrealm.sinusbot.api;

import com.google.gson.Gson;
import de.thecrealm.sinusbot.api.gson.SinusbotContainerPostProcessor;
import de.thecrealm.sinusbot.api.http.EntityEnclosingRequest;
import de.thecrealm.sinusbot.api.http.Request;
import de.thecrealm.sinusbot.api.items.SinusbotContainer;
import de.thecrealm.sinusbot.api.items.general.Login;
import de.thecrealm.sinusbot.api.items.instance.Instance;
import de.thecrealm.sinusbot.api.requests.general.GetBotIdRequest;
import de.thecrealm.sinusbot.api.requests.general.PostLoginRequest;
import de.thecrealm.sinusbot.api.requests.instances.GetListInstancesRequest;
import de.thecrealm.sinusbot.api.util.ClassUtil;
import io.gsonfire.GsonFireBuilder;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Created by creal on 09.11.2015.
 */
public class Sinusbot {

    /**
     * The value will will be added to the base url which together ponts to the v1 api.
     */
    public static final String API_BASE_URL_V1 = "/api/v1/";

    /**
     * The Access Token Header is required for authentication purposes.
     */
    public static final String ACCESS_TOKEN_HEADER = "Authorization";

    /**
     * Required!
     */
    public static final String ACCESS_TOKEN_VALUE_ADDITION = "bearer ";

    /**
     * Gson will serialize and deserialize the traffic to the rest api.
     * The registered post processor will set this sinusbot instance
     * to every class which extends the SinusbotContainer.
     */
    private Gson gson = new GsonFireBuilder()
            .registerPostProcessor(SinusbotContainer.class, new SinusbotContainerPostProcessor(this))
            .createGson();

    /**
     * The base url points to accessible website of your sinusbot.
     */
    private String baseUrl;

    /**
     * The access token is used for authentication.
     * It will be automatically set if you call the {@code #login} method.
     */
    private String accessToken;

    public Sinusbot(String baseUrl) {

        this.baseUrl = baseUrl;
    }

    /**
     * Returns the default bot id of the sinusbot you want to manage.
     *
     * @return The default botId.
     */
    public String getDefaultBotId() {

        return executeRequest(new GetBotIdRequest()).getBotId();
    }

    /**
     * Login into the sinusbot with the username and password.
     * The required bot id will we auto-retrieved with an api function!
     *
     * @param username The username.
     * @param password The password.
     * @return Returns true if the login was successful.
     */
    public boolean login(String username, String password) {

        return login(username, password, getDefaultBotId());
    }

    /**
     * Login into the sinusbot with the username, password and botId.
     *
     * @param username The username.
     * @param password The password.
     * @param botId The bot id to log into.
     * @return Returns true if the login was successful.
     */
    public boolean login(String username, String password, String botId) {

        Login login = executeRequest(new PostLoginRequest(username, password, botId));

        if(login.isSuccess()) {
            this.accessToken = login.getToken();
        }

        return login.isSuccess();
    }

    /**
     * Returns all instances of the sinusbot.
     *
     * @return Returns all instancs.
     */
    public List<Instance> getInstances() {

        return Arrays.asList(executeRequest(new GetListInstancesRequest()));
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public <TResult, TMessage extends HttpUriRequest> TResult executeRequest(Request<TResult, TMessage> apiRequest) {

        Type genericSuperclass = apiRequest.getClass().getGenericSuperclass();
        if(!(genericSuperclass instanceof ParameterizedType)) {
            genericSuperclass = ClassUtil.searchForSuperclassWithResponseType(apiRequest.getClass());
            if(genericSuperclass == null) return null;
        }
        ParameterizedType superType = (ParameterizedType) genericSuperclass;
        ParameterizedType parameterizedType = ClassUtil.searchForSuperclassWithHttpUriRequestType(apiRequest.getClass());
        Type responseType = superType.getActualTypeArguments()[0];
        Type messageType = parameterizedType.getActualTypeArguments()[1];
        Class<? extends HttpUriRequest> httpUriRequestClass = (Class<? extends HttpUriRequest>) messageType;
        URIBuilder builder = new URIBuilder(baseUrl + API_BASE_URL_V1 + apiRequest.getRelativePath());
        apiRequest.applyParameters(builder);
        Constructor<? extends HttpUriRequest> httpMessageConstructor = httpUriRequestClass.getConstructor(URI.class);
        URI uri = builder.build();
        HttpUriRequest httpMessage = httpMessageConstructor.newInstance(uri);
        httpMessage.addHeader(ACCESS_TOKEN_HEADER, ACCESS_TOKEN_VALUE_ADDITION + accessToken);
        //Add body
        if(apiRequest instanceof EntityEnclosingRequest) {
            httpMessage.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            HttpEntityEnclosingRequestBase enclosingRequest = ((HttpEntityEnclosingRequestBase) httpMessage);
            EntityEnclosingRequest ownRequest = ((EntityEnclosingRequest) apiRequest);
            ownRequest.applyBody(gson, enclosingRequest);
        }
        //Execute request
        try(CloseableHttpClient client = HttpClients.createDefault(); CloseableHttpResponse response = client.execute(httpMessage)) {
            String responseString = EntityUtils.toString(response.getEntity());
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                //throw new PushbulletApiException(gson.fromJson(extractError(responseString), PushbulletApiError.class)); TODO: own exception
            }
            System.out.println("<!- DEBUG -!> " + responseString);
            return gson.fromJson(responseString, responseType);
        }
    }
}
