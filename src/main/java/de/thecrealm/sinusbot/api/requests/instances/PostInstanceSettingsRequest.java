package de.thecrealm.sinusbot.api.requests.instances;

import com.google.gson.Gson;
import de.thecrealm.sinusbot.api.http.PostRequest;
import de.thecrealm.sinusbot.api.items.Success;
import de.thecrealm.sinusbot.api.items.instance.Instance;
import de.thecrealm.sinusbot.api.items.instance.InstanceSettings;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by creal on 09.11.2015.
 */
public class PostInstanceSettingsRequest extends PostRequest<Success> {

    private InstanceSettings settings;

    public PostInstanceSettingsRequest(InstanceSettings settings) {

        super("bot/i/" + settings.getSettingsFor().getUuid() + "/settings");
        this.settings = settings;
    }

    @Override
    public void applyBody(Gson gson, HttpPost post) {

        setJsonBody(gson.toJson(settings), post);
    }
}
