package com.vlingo.sdk.services.userlogging;

import com.vlingo.sdk.internal.deviceinfo.PhoneInfo;
import com.vlingo.sdk.internal.util.XmlUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class VLUserLoggerLogRecord {
    private List<VLErrorRecord> errors;
    private List<VLHelpPageRecord> helpPages;
    private List<VLLandingPageRecord> landingPages;
    private String settings;
    private boolean setupFinished;
    private boolean setupStarted;

    public static class Builder {
        private boolean setupStarted = false;
        private boolean setupFinished = false;
        private String settings = null;
        private List<VLHelpPageRecord> helpPages = new LinkedList();
        private List<VLErrorRecord> errors = new LinkedList();
        private List<VLLandingPageRecord> landingPages = new LinkedList();

        public Builder setupStarted(boolean setupStarted) {
            this.setupStarted = setupStarted;
            return this;
        }

        public Builder setupFinished(boolean setupFinished) {
            this.setupFinished = setupFinished;
            return this;
        }

        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }

        public Builder addHelpPageRecord(VLHelpPageRecord r) {
            this.helpPages.add(r);
            return this;
        }

        public Builder addErrorRecord(VLErrorRecord r) {
            this.errors.add(r);
            return this;
        }

        public Builder addLandingPageRecord(VLLandingPageRecord r) {
            this.landingPages.add(r);
            return this;
        }

        public VLUserLoggerLogRecord build() {
            return new VLUserLoggerLogRecord(this, null);
        }
    }

    private VLUserLoggerLogRecord(Builder builder) {
        this.setupStarted = false;
        this.setupFinished = false;
        this.settings = null;
        this.setupStarted = builder.setupStarted;
        this.setupFinished = builder.setupFinished;
        this.settings = builder.settings;
        this.helpPages = new LinkedList();
        this.helpPages.addAll(builder.helpPages);
        this.errors = new LinkedList();
        this.errors.addAll(builder.errors);
        this.landingPages = new LinkedList();
        this.landingPages.addAll(builder.landingPages);
    }

    /* synthetic */ VLUserLoggerLogRecord(Builder builder, VLUserLoggerLogRecord vLUserLoggerLogRecord) {
        this(builder);
    }

    public String getXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<user-log>");
        sb.append("<user-id>" + PhoneInfo.getInstance().getDeviceID() + "</user-id>");
        sb.append("<setup started=\"" + this.setupStarted + "\" finished=\"" + this.setupFinished + "\"/>");
        if (this.settings != null) {
            sb.append("<settings values=\"");
            sb.append(XmlUtils.xmlEncode(this.settings));
            sb.append("\"/>");
        }
        for (VLHelpPageRecord helpPage : this.helpPages) {
            sb.append(helpPage.generateXml());
        }
        for (VLErrorRecord error : this.errors) {
            sb.append(error.generateXml());
        }
        sb.append("<landing-pages>");
        for (VLLandingPageRecord page : this.landingPages) {
            page.generateXml();
        }
        sb.append("</landing-pages>");
        sb.append("</user-log>");
        return sb.toString();
    }
}
