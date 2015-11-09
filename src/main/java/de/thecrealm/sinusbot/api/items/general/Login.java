package de.thecrealm.sinusbot.api.items.general;

import lombok.Data;

/**
 * Created by creal on 09.11.2015.
 */
@Data
public class Login {

    private boolean success;
    private int code;
    private String error;
    private String token;
}
