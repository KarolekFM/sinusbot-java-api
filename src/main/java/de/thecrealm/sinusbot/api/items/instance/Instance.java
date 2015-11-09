package de.thecrealm.sinusbot.api.items.instance;

import de.thecrealm.sinusbot.api.items.SinusbotContainer;
import de.thecrealm.sinusbot.api.requests.instances.GetInstanceSettingsRequest;
import de.thecrealm.sinusbot.api.requests.playback.PostSetValueRequest;
import lombok.Data;

/**
 * Created by creal on 09.11.2015.
 */
@Data
public class Instance extends SinusbotContainer {

    private String uuid;
    private String nick;
    private String name;
    private boolean running;
    private boolean mainInstance;

    public InstanceSettings loadSettings() {

        InstanceSettings settings = getSinusbot().executeRequest(new GetInstanceSettingsRequest(this));
        settings.setSettingsFor(this);
        return settings;
    }

    public boolean setVolume(int newVolume) {

        return getSinusbot().executeRequest(new PostSetValueRequest(this, newVolume)).isSuccess();
    }
}
