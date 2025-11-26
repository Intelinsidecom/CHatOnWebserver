package com.vlingo.sdk.internal.deviceinfo;

/* loaded from: classes.dex */
public class CountryUtils {
    public static String ISO3ToISO2CountryCode(String iso3Code) {
        String iso2Code = CountryCodes.getInstance().getIso2FromIso3(iso3Code);
        return iso2Code;
    }

    public static String ISO2ToISO3CountryCode(String iso2Code) {
        String iso3Code = CountryCodes.getInstance().getIso3FromIso2(iso2Code);
        return iso3Code;
    }
}
