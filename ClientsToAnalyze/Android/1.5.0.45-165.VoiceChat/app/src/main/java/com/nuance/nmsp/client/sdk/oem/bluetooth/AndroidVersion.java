package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.os.Build;

/* loaded from: classes.dex */
public class AndroidVersion {
    public static final int BASE = 1;
    public static final int BASE_1_1 = 2;
    public static final int CUPCAKE = 3;
    public static final int CUR_DEVELOPMENT = 10000;
    public static final int DONUT = 4;
    public static final int ECLAIR = 5;
    public static final int ECLAIR_0_1 = 6;
    public static final int ECLAIR_MR1 = 7;
    public static final boolean FIX_FOR_GARBLED_BLUETOOTH_AUDIO;
    public static final int FROYO = 8;
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final boolean HAS_WORKING_A2DP_CONTROL;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    public static final boolean IS_BROKEN_HTC;
    public static final boolean IS_BROKEN_MOTOROLA_i1;
    public static final boolean IS_BROKEN_SAMSUNG;
    public static final String MANUFACTURER;
    public static final int SDK = Integer.parseInt(Build.VERSION.SDK);
    public static final boolean SKIP_INITIATE_SPP_CONNECTION;
    public static final boolean USE_MUSIC_STREAM_FOR_BLUETOOTH;

    /* renamed from: a */
    private static final boolean f350a;

    /* renamed from: b */
    private static final boolean f351b;

    static {
        String str;
        try {
            str = (String) Build.class.getField("MANUFACTURER").get(null);
        } catch (Exception e) {
            str = "";
        }
        MANUFACTURER = str;
        String str2 = Build.MODEL;
        IS_BROKEN_SAMSUNG = str.equalsIgnoreCase("samsung") && (str2.equalsIgnoreCase("SGH-T959") || str2.equalsIgnoreCase("SAMSUNG-SGH-I897") || str2.equalsIgnoreCase("SGH-I897") || str2.equalsIgnoreCase("GT-I9000"));
        IS_BROKEN_HTC = str.equalsIgnoreCase("htc") && (str2.equalsIgnoreCase("PC36100") || str2.equalsIgnoreCase("ADR6300") || str2.equalsIgnoreCase("HTC Glacier") || str2.equalsIgnoreCase("T-Mobile myTouch 4G") || str2.equalsIgnoreCase("T-Mobile G2"));
        IS_BROKEN_MOTOROLA_i1 = str2.equalsIgnoreCase("Motorola_i1");
        f351b = str.equalsIgnoreCase("Motorola") && str2.equalsIgnoreCase("MB860");
        boolean z = str.equalsIgnoreCase("samsung") && SDK == 8;
        f350a = z;
        SKIP_INITIATE_SPP_CONNECTION = z;
        USE_MUSIC_STREAM_FOR_BLUETOOTH = IS_BROKEN_SAMSUNG || IS_BROKEN_MOTOROLA_i1;
        HAS_WORKING_A2DP_CONTROL = IS_BROKEN_SAMSUNG ? false : true;
        FIX_FOR_GARBLED_BLUETOOTH_AUDIO = f351b;
    }
}
