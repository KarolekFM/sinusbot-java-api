package de.thecrealm.sinusbot.api.requests.instances;

import de.thecrealm.sinusbot.api.http.GetRequest;
import de.thecrealm.sinusbot.api.items.instance.Instance;
import de.thecrealm.sinusbot.api.items.instance.InstanceSettings;

/**
 * Created by creal on 09.11.2015.
 */
public class GetInstanceSettingsRequest extends GetRequest<InstanceSettings> {

    public GetInstanceSettingsRequest(Instance instance) {

        super("bot/i/" + instance.getUuid() + "/settings");
    }
}
