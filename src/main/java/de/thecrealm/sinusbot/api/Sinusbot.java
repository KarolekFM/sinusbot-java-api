package de.thecrealm.sinusbot.api;

/**
 * Created by creal on 09.11.2015.
 */
public class Sinusbot {

    public static final String URL_API_V1 = "api/v1/";
    public static final String AUTH_KEY = "Authentication";

    private String baseUrl;
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

    }
}
