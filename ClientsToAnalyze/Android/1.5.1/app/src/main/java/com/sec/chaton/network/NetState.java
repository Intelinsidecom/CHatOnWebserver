package com.sec.chaton.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public class NetState {
    /* renamed from: a */
    public static int m2753a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (!activeNetworkInfo.isAvailable()) {
                return -2;
            }
            int type = activeNetworkInfo.getType();
            switch (type) {
            }
            return -3;
        }
        return -3;
    }

    /* renamed from: a */
    public static int m2754a(Context context, String str) throws UnknownHostException {
        int iM2753a = m2753a(context);
        if (iM2753a == -3 || iM2753a == -2) {
            return iM2753a;
        }
        try {
            InetAddress.getAllByName(str);
            return iM2753a;
        } catch (UnknownHostException e) {
            return -1;
        }
    }
}
