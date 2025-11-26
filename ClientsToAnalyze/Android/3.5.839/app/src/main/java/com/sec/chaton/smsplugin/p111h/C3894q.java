package com.sec.chaton.smsplugin.p111h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetState.java */
/* renamed from: com.sec.chaton.smsplugin.h.q */
/* loaded from: classes.dex */
public class C3894q {
    /* renamed from: a */
    public static int m15037a(Context context) {
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
}
