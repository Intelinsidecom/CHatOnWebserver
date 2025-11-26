package com.sec.chaton.p018c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: NetState.java */
/* renamed from: com.sec.chaton.c.i */
/* loaded from: classes.dex */
public class C0502i {
    /* renamed from: a */
    public static int m2526a(Context context) {
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
    public static int m2527a(Context context, String str) throws UnknownHostException {
        int iM2526a = m2526a(context);
        if (iM2526a != -3 && iM2526a != -2) {
            try {
                InetAddress.getAllByName(str);
                return iM2526a;
            } catch (UnknownHostException e) {
                return -1;
            }
        }
        return iM2526a;
    }
}
