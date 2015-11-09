package de.thecrealm.sinusbot.api.requests.general;

import de.thecrealm.sinusbot.api.http.GetRequest;
import de.thecrealm.sinusbot.api.items.general.BotId;

/**
 * Created by creal on 07.11.2015.
 */
public class GetBotIdRequest extends GetRequest<BotId> {

    public GetBotIdRequest() {

        super("botId");
    }
}
