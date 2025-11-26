package com.coolots.chaton.buddy.model;

/* loaded from: classes.dex */
public class BuddyCountry {
    private String mCountryCode;
    private String mCountryName;

    public BuddyCountry(String countryName, String countryCode) {
        this.mCountryName = countryName;
        this.mCountryCode = countryCode;
    }

    public String getmCountryName() {
        return this.mCountryName;
    }

    public void setmCountryName(String countryName) {
        this.mCountryName = countryName;
    }

    public String getmCountryCode() {
        return this.mCountryCode;
    }

    public void setmCountryCode(String countryCode) {
        this.mCountryCode = countryCode;
    }
}
