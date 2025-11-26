package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class TranslateTextResp {
    private String language;
    private long rcode;
    private String rmsg;
    private String source_text;
    private String target_text;
    private long timestamp;

    public long getRcode() {
        return this.rcode;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getSourceText() {
        return this.source_text;
    }

    public String getTargetText() {
        return this.target_text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getRmsg() {
        return this.rmsg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TranslateTextResp [rcode=").append(this.rcode).append(", language=").append(this.language).append(", source_text=").append(this.source_text).append(", target_text=").append(this.target_text).append(", timestamp=").append(this.timestamp).append(", rmsg=").append(this.rmsg).append("]");
        return sb.toString();
    }
}
