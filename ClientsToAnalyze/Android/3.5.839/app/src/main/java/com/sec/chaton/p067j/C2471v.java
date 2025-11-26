package com.sec.chaton.p067j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: NetState.java */
/* renamed from: com.sec.chaton.j.v */
/* loaded from: classes.dex */
public class C2471v {
    /* renamed from: a */
    public static int m10677a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                switch (type) {
                }
                return -3;
            }
            return -2;
        }
        return -3;
    }

    /* renamed from: a */
    public static int m10678a(Context context, String str) throws UnknownHostException {
        int iM10677a = m10677a(context);
        if (iM10677a != -3 && iM10677a != -2) {
            try {
                InetAddress.getAllByName(str);
                return iM10677a;
            } catch (UnknownHostException e) {
                return -1;
            }
        }
        return iM10677a;
    }

    /* renamed from: b */
    public static boolean m10679b(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    /* renamed from: c */
    public static boolean m10680c(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_on", 0) != 0;
    }

    /* renamed from: d */
    public static boolean m10681d(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "data_roaming", 0) != 0;
    }

    /* renamed from: e */
    public static boolean m10682e(Context context) throws NoSuchMethodException, SecurityException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Method method = Class.forName(connectivityManager.getClass().getName()).getMethod("getMobileDataEnabled", new Class[0]);
            method.setAccessible(true);
            if (method != null) {
                return ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m10683f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDataState() == 2;
    }

    /* renamed from: g */
    public static boolean m10684g(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.isNetworkRoaming();
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m10685h(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m10686i(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(7);
        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        }
        return false;
    }
}
