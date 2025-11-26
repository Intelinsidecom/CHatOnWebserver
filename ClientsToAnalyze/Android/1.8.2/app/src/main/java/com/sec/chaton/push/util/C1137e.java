package com.sec.chaton.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.PushClientApplication;

/* compiled from: NetworkUtil.java */
/* renamed from: com.sec.chaton.push.util.e */
/* loaded from: classes.dex */
public class C1137e {

    /* renamed from: a */
    private static Context f4136a = PushClientApplication.m4111g();

    /* renamed from: a */
    public static EnumC1138f m4304a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f4136a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? EnumC1138f.NoActive : EnumC1138f.m4306a(activeNetworkInfo.getType());
    }

    /* renamed from: b */
    public static String m4305b() {
        return ((TelephonyManager) PushClientApplication.m4111g().getSystemService("phone")).getNetworkOperator();
    }
}
