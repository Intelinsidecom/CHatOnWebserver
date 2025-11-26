package com.coolots.chaton.join.model;

/* loaded from: classes.dex */
public class BackupAuthInfo {
    public String authCode;
    public int countryCode;
    public boolean isSMS;
    public String language;
    public String phoneNo;

    public BackupAuthInfo(int countryCode, String phoneNo, boolean isSMS, String language, String authCode) {
        this.countryCode = countryCode;
        this.phoneNo = phoneNo;
        this.language = language;
        this.authCode = authCode;
        this.isSMS = isSMS;
    }
}
