package com.vlingo.sdk.internal.deviceinfo;

/* loaded from: classes.dex */
public class CarrierUtils {
    public static Carrier getCarrier(String networkName) {
        if (networkName == null || networkName.length() == 0) {
            return null;
        }
        return Carriers.getInstance().getCarrierByName(networkName);
    }

    public static String getCarrierISO2Country(String networkName) {
        Carrier c = getCarrier(networkName);
        if (c != null) {
            return c.iso2letterCountry;
        }
        return null;
    }
}
