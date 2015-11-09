package de.thecrealm.sinusbot.api.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import de.thecrealm.sinusbot.api.Sinusbot;
import de.thecrealm.sinusbot.api.items.SinusbotContainer;
import io.gsonfire.PostProcessor;

/**
 * Created by creal on 09.11.2015.
 */
public class SinusbotContainerPostProcessor implements PostProcessor<SinusbotContainer> {

    private Sinusbot sinusbot;

    public SinusbotContainerPostProcessor(Sinusbot sinusbot) {

        this.sinusbot = sinusbot;
    }

    @Override
    public void postDeserialize(SinusbotContainer sinusbotContainer, JsonElement jsonElement, Gson gson) {

        if(null != sinusbotContainer) {
            sinusbotContainer.setSinusbot(sinusbot);
        }
    }

    @Override
    public void postSerialize(JsonElement jsonElement, SinusbotContainer sinusbotContainer, Gson gson) {

    }
}
