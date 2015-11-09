package de.thecrealm.sinusbot.api.items.general;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by creal on 09.11.2015.
 */
@Data
public class BotId {

    @SerializedName("defaultBotId")
    private String botId;
}
