package com.sec.chaton.smsplugin.p111h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* compiled from: NetworkConnectionUtils.java */
/* renamed from: com.sec.chaton.smsplugin.h.r */
/* loaded from: classes.dex */
public class C3895r {
    /* renamed from: a */
    public static boolean m15038a(Context context, boolean z) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            Log.e("Mms/NetworkConnectionUtils", "mConnMgr is null return false");
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(2);
        if (z) {
            boolean zIsAvailable = networkInfo.isAvailable();
            Log.d("Mms/NetworkConnectionUtils", "isMessageNetworkAvailable = " + zIsAvailable);
            return zIsAvailable;
        }
        boolean zIsAvailable2 = networkInfo == null ? false : networkInfo.isAvailable();
        if (zIsAvailable2) {
            if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                return true;
            }
            Log.d("Mms/NetworkConnectionUtils", "mConnMgr is null or mConnMgr.getActiveNetworkInfo() is null");
            return false;
        }
        Log.d("Mms/NetworkConnectionUtils", "isMessageNetworkAvailable = " + zIsAvailable2);
        return false;
    }
}
