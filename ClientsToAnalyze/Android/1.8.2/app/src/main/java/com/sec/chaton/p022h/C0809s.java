package com.sec.chaton.p022h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: NetState.java */
/* renamed from: com.sec.chaton.h.s */
/* loaded from: classes.dex */
public class C0809s {
    /* renamed from: a */
    public static int m3420a(Context context) {
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
    public static int m3421a(Context context, String str) throws UnknownHostException {
        int iM3420a = m3420a(context);
        if (iM3420a != -3 && iM3420a != -2) {
            try {
                InetAddress.getAllByName(str);
                return iM3420a;
            } catch (UnknownHostException e) {
                return -1;
            }
        }
        return iM3420a;
    }
}
