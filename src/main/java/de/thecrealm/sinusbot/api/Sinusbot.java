package de.thecrealm.sinusbot.api;

/**
 * Created by creal on 09.11.2015.
 */
public class Sinusbot {

    public String getDefaultBotId() {

    }

    public boolean login(String username, String password) {

        return login(username, password, getDefaultBotId());
    }

    public boolean login(String username, String password, String botId) {
        
    }
}
