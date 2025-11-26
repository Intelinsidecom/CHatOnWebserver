package com.sec.chaton.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.PushClientApplication;
import com.sec.common.CommonApplication;

/* compiled from: NetworkUtil.java */
/* renamed from: com.sec.chaton.push.util.e */
/* loaded from: classes.dex */
public class C2113e {

    /* renamed from: a */
    private static Context f8042a = PushClientApplication.m11493l();

    /* renamed from: a */
    public static EnumC2114f m8355a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f8042a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? EnumC2114f.NoActive : EnumC2114f.m8357a(activeNetworkInfo.getType());
    }

    /* renamed from: b */
    public static String m8356b() {
        return ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getNetworkOperator();
    }
}
