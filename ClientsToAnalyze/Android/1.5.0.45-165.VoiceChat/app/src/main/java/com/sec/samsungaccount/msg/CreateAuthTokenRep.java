package com.sec.samsungaccount.msg;

/* loaded from: classes.dex */
public class CreateAuthTokenRep extends JasonParser {
    private static final String TAG_EXPIRES = "userauth_token_expires_in";
    private static final String TAG_TOKEN = "userauth_token";

    public CreateAuthTokenRep(String msg) {
        super(msg);
    }

    public String parseAuthToken() {
        return parseString(TAG_TOKEN);
    }

    public int parseExpires() {
        return parseInteger(TAG_EXPIRES);
    }
}
