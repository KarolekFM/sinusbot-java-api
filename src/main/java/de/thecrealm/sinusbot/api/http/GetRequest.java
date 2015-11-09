package de.thecrealm.sinusbot.api.http;

import org.apache.http.client.methods.HttpGet;

public abstract class GetRequest<TResult> extends Request<TResult, HttpGet> {
    
    public GetRequest(String relativePath) {
        super(relativePath);
    }
}