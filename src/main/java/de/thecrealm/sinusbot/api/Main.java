package de.thecrealm.sinusbot.api;

import de.thecrealm.sinusbot.api.items.instance.Instance;

/**
 * Created by creal on 09.11.2015.
 */
public class Main {

    public static void main(String[] args) {

        Sinusbot sinusbot = new Sinusbot("http://bot-1.crealmhost.de");
        sinusbot.login("api", "api");

        for (Instance instance : sinusbot.getInstances()) {
            System.out.println(instance.getName());
            instance.loadSettings().setUpdateDescription(true).update();
        }


    }
}
