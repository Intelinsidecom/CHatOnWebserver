package com.sec.samsungaccount.msg;

/* loaded from: classes.dex */
public class DeleteAccessTokenRep extends JasonParser {
    private static final String STRING_TRUE = "true";
    private static final String TAG_RESULT = "result";

    public DeleteAccessTokenRep(String msg) {
        super(msg);
    }

    public boolean parseResult() {
        String res = parseString("result");
        return STRING_TRUE.equals(res);
    }
}
