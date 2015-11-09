package de.thecrealm.sinusbot.api.requests.instances;

import de.thecrealm.sinusbot.api.http.GetRequest;
import de.thecrealm.sinusbot.api.items.instance.Instance;

/**
 * Created by creal on 09.11.2015.
 */
public class GetListInstancesRequest extends GetRequest<Instance[]> {

    public GetListInstancesRequest() {

        super("bot/instances");
    }
}
