package com.vlingo.sdk.internal.deviceinfo;

/* loaded from: classes.dex */
public class Carrier {
    public String iso2letterCountry;
    public String iso3letterCountry;
    public String name;

    public Carrier(String name, String iso2letterCountry, String iso3letterCountry) {
        this.name = name;
        this.iso2letterCountry = iso2letterCountry;
        this.iso3letterCountry = iso3letterCountry;
    }
}
