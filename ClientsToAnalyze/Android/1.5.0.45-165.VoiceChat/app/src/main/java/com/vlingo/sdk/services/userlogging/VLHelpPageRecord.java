package com.vlingo.sdk.services.userlogging;

import com.vlingo.sdk.internal.util.XmlUtils;

/* loaded from: classes.dex */
public class VLHelpPageRecord {
    public static final int MAX_LENGTH = 128;
    private String mPageId;
    private int mViewCount;

    public static class Builder {
        private String pageId;
        private int viewCount;

        public Builder(String pageId) {
            this.pageId = pageId;
        }

        public Builder pageViewed() {
            this.viewCount++;
            return this;
        }

        public VLHelpPageRecord build() {
            return new VLHelpPageRecord(this, null);
        }
    }

    private VLHelpPageRecord(Builder builder) {
        this.mPageId = builder.pageId;
        this.mViewCount = builder.viewCount;
    }

    /* synthetic */ VLHelpPageRecord(Builder builder, VLHelpPageRecord vLHelpPageRecord) {
        this(builder);
    }

    public String getPageId() {
        return this.mPageId;
    }

    public int getViewCount() {
        return this.mViewCount;
    }

    String generateXml() {
        return "<help-page page-id=\"" + XmlUtils.xmlEncode(this.mPageId) + "\" count=\"" + this.mViewCount + "\"/>";
    }
}
