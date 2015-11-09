package de.thecrealm.sinusbot.api.requests.playback;

import com.google.gson.Gson;
import de.thecrealm.sinusbot.api.http.PostRequest;
import de.thecrealm.sinusbot.api.items.Success;
import de.thecrealm.sinusbot.api.items.instance.Instance;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by creal on 09.11.2015.
 */
public class PostSetValueRequest extends PostRequest<Success> {

    private String instanceId;
    private int volume;

    public PostSetValueRequest(Instance instance, int volume) {

        super("bot/i/:instanceId/volume/set/:volume");
        this.instanceId = instance.getUuid();
        this.volume = volume;
    }

    @Override
    public void applyBody(Gson gson, HttpPost post) {

        setJsonBody(gson.toJson(this), post);
    }
}
