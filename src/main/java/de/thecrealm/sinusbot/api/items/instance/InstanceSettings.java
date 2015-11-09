package de.thecrealm.sinusbot.api.items.instance;

import de.thecrealm.sinusbot.api.requests.instances.PostInstanceSettingsRequest;
import lombok.Getter;

@Getter
public class InstanceSettings {

    private Instance settingsFor;

    private String nick;
    private String serverHost;
    private int serverPort;
    private String serverPassword;
    private String channelName;
    private String channelPassword;
    private boolean updateDescription;
    private boolean announce;
    private String annonuceString;
    private String identy;
    private boolean enableDucking;
    private int duckingVolume;
    private boolean channelCommander;
    private boolean stickToChannel;
    private String ttsExternalURL;
    private String ttsDefaultLocale;
    private boolean ignoreChatServer;
    private boolean ignoreChatPrivate;
    private boolean ignoreChatChannel;
    private String idleTrack;
    private String startupTrack;

    public void setSettingsFor(Instance settingsFor) {

        this.settingsFor = settingsFor;
    }

    public InstanceSettings setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public InstanceSettings setServerHost(String serverHost) {
        this.serverHost = serverHost;
        return this;
    }

    public InstanceSettings setServerPort(int serverPort) {
        this.serverPort = serverPort;
        return this;
    }

    public InstanceSettings setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
        return this;
    }

    public InstanceSettings setChannelName(String channelName) {
        this.channelName = channelName;
        return this;
    }

    public InstanceSettings setChannelPassword(String channelPassword) {
        this.channelPassword = channelPassword;
        return this;
    }

    public InstanceSettings setUpdateDescription(boolean updateDescription) {
        this.updateDescription = updateDescription;
        return this;
    }

    public InstanceSettings setAnnounce(boolean announce) {
        this.announce = announce;
        return this;
    }

    public InstanceSettings setAnnonuceString(String annonuceString) {
        this.annonuceString = annonuceString;
        return this;
    }

    public InstanceSettings setIdenty(String identy) {
        this.identy = identy;
        return this;
    }

    public InstanceSettings setEnableDucking(boolean enableDucking) {
        this.enableDucking = enableDucking;
        return this;
    }

    public InstanceSettings setDuckingVolume(int duckingVolume) {
        this.duckingVolume = duckingVolume;
        return this;
    }

    public InstanceSettings setChannelCommander(boolean channelCommander) {
        this.channelCommander = channelCommander;
        return this;
    }

    public InstanceSettings setStickToChannel(boolean stickToChannel) {
        this.stickToChannel = stickToChannel;
        return this;
    }

    public InstanceSettings setTtsExternalURL(String ttsExternalURL) {
        this.ttsExternalURL = ttsExternalURL;
        return this;
    }

    public InstanceSettings setTtsDefaultLocale(String ttsDefaultLocale) {
        this.ttsDefaultLocale = ttsDefaultLocale;
        return this;
    }

    public InstanceSettings setIgnoreChatServer(boolean ignoreChatServer) {
        this.ignoreChatServer = ignoreChatServer;
        return this;
    }

    public InstanceSettings setIgnoreChatPrivate(boolean ignoreChatPrivate) {
        this.ignoreChatPrivate = ignoreChatPrivate;
        return this;
    }

    public InstanceSettings setIgnoreChatChannel(boolean ignoreChatChannel) {
        this.ignoreChatChannel = ignoreChatChannel;
        return this;
    }

    public InstanceSettings setIdleTrack(String idleTrack) {
        this.idleTrack = idleTrack;
        return this;
    }

    public InstanceSettings setStartupTrack(String startupTrack) {
        this.startupTrack = startupTrack;
        return this;
    }

    public boolean update() {

        return settingsFor.getSinusbot().executeRequest(new PostInstanceSettingsRequest(this)).isSuccess();
    }
}