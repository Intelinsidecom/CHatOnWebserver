package com.vlingo.sdk.internal.vlservice.response;

/* loaded from: classes.dex */
public class ServerMessage {
    public static final int ERROR = 3;
    public static final String ERROR_INVALID_APPID = "012";
    public static final String ERROR_INVALID_FIELDID = "013";
    public static final int STATUS = 1;
    public static final int WARNING = 2;
    private int type = -1;
    private String message = "";
    private String code = "";
    private String detailMessage = "";
    private String detailCode = "";

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setMessage(String text) {
        this.message = text;
    }

    public String getMessage() {
        String txt = this.message;
        if (this.detailMessage != null && this.detailMessage.length() > 0) {
            return String.valueOf(txt) + ": " + this.detailMessage;
        }
        return txt;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public String getDetailCode() {
        return this.detailCode;
    }

    public String getFullMessage() {
        return String.valueOf(this.message) + ": " + this.detailMessage + "(" + this.code + ")";
    }

    public String toString() {
        return getFullMessage();
    }
}
