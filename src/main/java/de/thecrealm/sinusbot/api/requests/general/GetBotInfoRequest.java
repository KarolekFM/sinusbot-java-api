package de.thecrealm.sinusbot.api.requests.general;

import de.thecrealm.sinusbot.api.http.GetRequest;
import de.thecrealm.sinusbot.api.items.general.BotInfo;

/**
 * Created by creal on 07.11.2015.
 */
public class GetBotInfoRequest extends GetRequest<BotInfo> {

    public GetBotInfoRequest() {

        super("bot/info");
    }
}
