package de.thecrealm.sinusbot.api.items.general;

import lombok.Data;

import java.util.List;

/**
 * Created by creal on 09.11.2015.
 */
@Data
public class BotInfo {

    private Bot bot;
    private double usageMemory;
    private System system;

    @Data
    public class Bot {

        private String id;
        private String alias;
        private int spaceUsed;
        private int limitSpace;
        private int limitFiles;
        private int limitPlaylists;
        private int limitInstances;
        private int limitUsers;
        private int limitDownloadRate;
        private int limitDownloadSize;
        private int locked;
        private int deleted;
        private int disallowDownload;
        private int disallowStreaming;
        private int downloadedBytes;
        private int statHTTPRequests;
        private int statPlayCount;
        private int statCommandCount;
    }

    @Data
    public class System {

        private List<String> codecs;
    }
}
