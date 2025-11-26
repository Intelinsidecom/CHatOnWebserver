package com.vlingo.sdk.services.userlogging;

import com.vlingo.sdk.internal.util.XmlUtils;

/* loaded from: classes.dex */
public class VLErrorRecord {
    private String mErrorId;
    private int mViewCount;

    public static class Builder {
        private String errorId;
        private int viewCount;

        public Builder(String errorId) {
            this.errorId = errorId;
        }

        public Builder errorDisplayed() {
            this.viewCount++;
            return this;
        }

        public VLErrorRecord build() {
            return new VLErrorRecord(this, null);
        }
    }

    private VLErrorRecord(Builder builder) {
        this.mErrorId = builder.errorId;
        this.mViewCount = builder.viewCount;
    }

    /* synthetic */ VLErrorRecord(Builder builder, VLErrorRecord vLErrorRecord) {
        this(builder);
    }

    public String getErrorId() {
        return this.mErrorId;
    }

    public int getErrorCount() {
        return this.mViewCount;
    }

    String generateXml() {
        return "<error msg-id=\"" + XmlUtils.xmlEncode(this.mErrorId) + "\" count=\"" + this.mViewCount + "\"/>";
    }
}
