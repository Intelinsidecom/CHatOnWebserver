package com.sec.samsungaccount.msg;

/* loaded from: classes.dex */
public class UpdateAccessTokenRep extends JasonParser {
    private static final String TAG_ACCESS_TOKEN = "access_token";
    private static final String TAG_ACCESS_TOKEN_EXPIRES = "access_token_expires_in";
    private static final String TAG_REFRESH_TOKEN = "refresh_token";
    private static final String TAG_REFRESH_TOKEN_EXPIRES = "refresh_token_expires_in";
    private static final String TAG_TOKEN_TYPE = "token_type";
    private static final String TAG_USERID = "userId";

    public UpdateAccessTokenRep(String msg) {
        super(msg);
    }

    public String parseAccessToken() {
        return parseString(TAG_ACCESS_TOKEN);
    }

    public String parseTokenType() {
        return parseString(TAG_TOKEN_TYPE);
    }

    public int parseAccessTokenExpires() {
        return parseInteger(TAG_ACCESS_TOKEN_EXPIRES);
    }

    public String parseRefreshToken() {
        return parseString(TAG_REFRESH_TOKEN);
    }

    public int parseRefreshTokenExpires() {
        return parseInteger(TAG_REFRESH_TOKEN_EXPIRES);
    }

    public String parseUserID() {
        return parseString(TAG_USERID);
    }
}
