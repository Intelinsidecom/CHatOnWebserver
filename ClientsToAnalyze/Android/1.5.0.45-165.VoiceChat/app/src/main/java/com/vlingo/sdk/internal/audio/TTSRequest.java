package com.vlingo.sdk.internal.audio;

/* loaded from: classes.dex */
public class TTSRequest {
    public String body;
    public String gender;
    public String senderAddress;
    public String senderDisplayName;
    public boolean senderOnly;
    public String subject;
    public String type;
    public int wordLimit = 0;
    public String speechRate = TTSRequestParams.SPEECHRATE_NORMAL;

    protected TTSRequest() {
    }

    public static TTSRequest getText(String text) {
        TTSRequest req = new TTSRequest();
        req.type = TTSRequestParams.TYPE_CONFIRM;
        req.body = text;
        return req;
    }

    public static TTSRequest getEmail(String senderName, String subject, String body, boolean senderOnly) {
        TTSRequest req = new TTSRequest();
        req.type = TTSRequestParams.TYPE_EMAIL;
        req.senderDisplayName = senderName;
        req.subject = subject;
        req.body = body;
        req.senderOnly = senderOnly;
        return req;
    }

    public static TTSRequest getSMS(String senderName, String body, boolean senderOnly) {
        TTSRequest req = new TTSRequest();
        req.type = TTSRequestParams.TYPE_SMS;
        req.senderDisplayName = senderName;
        req.body = body;
        req.senderOnly = senderOnly;
        return req;
    }

    public static TTSRequest getMMS(String senderName, String subject, boolean senderOnly) {
        TTSRequest req = new TTSRequest();
        req.type = TTSRequestParams.TYPE_MMS;
        req.senderDisplayName = senderName;
        req.subject = subject;
        req.senderOnly = senderOnly;
        return req;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWordLimit(int limit) {
        this.wordLimit = limit;
    }

    public void setSpeechRate(String rate) {
        this.speechRate = rate;
    }
}
