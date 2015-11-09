package de.thecrealm.sinusbot.api.requests.general;

import com.google.gson.Gson;
import de.thecrealm.sinusbot.api.http.PostRequest;
import de.thecrealm.sinusbot.api.items.general.Login;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by creal on 07.11.2015.
 */
public class PostLoginRequest extends PostRequest<Login> {

    private String username;
    private String password;
    private String botId;

    public PostLoginRequest(String username, String password, String botId) {

        super("bot/login");

        this.username = username;
        this.password = password;
        this.botId = botId;
    }

    @Override
    public void applyBody(Gson gson, HttpPost post) {

        setJsonBody(gson.toJson(this), post);
    }
}
