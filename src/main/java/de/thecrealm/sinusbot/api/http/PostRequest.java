package de.thecrealm.sinusbot.api.http;

import org.apache.http.client.methods.HttpPost;

public class PostRequest<TResult> extends EntityEnclosingRequest<TResult, HttpPost> {

    public PostRequest(String relativePath) {
        super(relativePath);
    }
}
