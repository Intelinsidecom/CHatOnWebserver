package com.sec.chaton.p037j;

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
public class C1594v {
    /* renamed from: a */
    public static int m6733a(Context context) {
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
    public static int m6734a(Context context, String str) throws UnknownHostException {
        int iM6733a = m6733a(context);
        if (iM6733a != -3 && iM6733a != -2) {
            try {
                InetAddress.getAllByName(str);
                return iM6733a;
            } catch (UnknownHostException e) {
                return -1;
            }
        }
        return iM6733a;
    }

    /* renamed from: b */
    public static boolean m6735b(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    /* renamed from: c */
    public static boolean m6736c(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_on", 0) != 0;
    }

    /* renamed from: d */
    public static boolean m6737d(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "data_roaming", 0) != 0;
    }

    /* renamed from: e */
    public static boolean m6738e(Context context) throws NoSuchMethodException, SecurityException {
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
    public static boolean m6739f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDataState() == 2;
    }

    /* renamed from: g */
    public static boolean m6740g(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.isNetworkRoaming();
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m6741h(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        }
        return false;
    }
}
