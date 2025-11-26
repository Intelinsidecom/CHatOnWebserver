package com.sec.chaton.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.PushClientApplication;

/* compiled from: NetworkUtil.java */
/* renamed from: com.sec.chaton.push.util.f */
/* loaded from: classes.dex */
public class C0920f {

    /* renamed from: a */
    private static Context f3115a = PushClientApplication.m3436a();

    /* renamed from: a */
    public static EnumC0918d m3634a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f3115a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? EnumC0918d.NoActive : EnumC0918d.m3619a(activeNetworkInfo.getType());
    }

    /* renamed from: b */
    public static String m3635b() {
        return ((TelephonyManager) PushClientApplication.m3436a().getSystemService("phone")).getNetworkOperator();
    }
}
