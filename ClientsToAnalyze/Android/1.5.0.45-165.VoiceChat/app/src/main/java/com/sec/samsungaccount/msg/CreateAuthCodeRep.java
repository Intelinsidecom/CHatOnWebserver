package com.sec.samsungaccount.msg;

/* loaded from: classes.dex */
public class CreateAuthCodeRep extends JasonParser {
    private static final String TAG_CODE = "code";
    private static final String TAG_EXPIRES = "code_expires_in";
    private static final String TAG_STATE = "state";

    public CreateAuthCodeRep(String msg) {
        super(msg);
    }

    public String parseCode() {
        return parseString("code");
    }

    public String parseState() {
        return parseString(TAG_STATE);
    }

    public int parseExpires() {
        return parseInteger(TAG_EXPIRES);
    }
}
