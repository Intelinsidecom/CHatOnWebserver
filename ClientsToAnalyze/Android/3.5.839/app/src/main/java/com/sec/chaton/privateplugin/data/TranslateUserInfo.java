package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class TranslateUserInfo {
    private String error;
    private long error_code;
    private String error_description;
    private ProvisioningInfo gld_region;
    private long rcode;
    private String uid;

    public long getRcode() {
        return this.rcode;
    }

    public String getUid() {
        return this.uid;
    }

    public ProvisioningInfo getGldRegion() {
        return this.gld_region;
    }

    public long getErrorCode() {
        return this.error_code;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorDescription() {
        return this.error_description;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TranslateUserInfo [rcode=").append(this.rcode).append(", uid=").append(this.uid).append(", gld_region=").append(this.gld_region).append(", error_code=").append(this.error_code).append(", error=").append(this.error).append(", error_description=").append(this.error_description).append("]");
        return sb.toString();
    }
}
