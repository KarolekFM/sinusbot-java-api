package de.thecrealm.sinusbot.api.http;

import org.apache.http.client.methods.HttpDelete;

public class DeleteRequest<TResult> extends Request<TResult, HttpDelete> {

    public DeleteRequest(String relativePath) {
        super(relativePath);
    }
}
