package de.thecrealm.sinusbot.api.requests.instances;

import com.google.gson.Gson;
import de.thecrealm.sinusbot.api.http.PostRequest;
import de.thecrealm.sinusbot.api.items.Success;
import de.thecrealm.sinusbot.api.items.instance.Instance;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by creal on 07.11.2015.
 */
public class LaunchInstanceRequest extends PostRequest<Success> {

    private String instanceId;

    public LaunchInstanceRequest(Instance instance) {

        super("bot/i/" + instance.getUuid() + "/spawn");
        this.instanceId = instance.getUuid();
    }

    @Override
    public void applyBody(Gson gson, HttpPost post) {

        setJsonBody(gson.toJson(this), post);
    }
}
