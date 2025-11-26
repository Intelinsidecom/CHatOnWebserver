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
public class C3113e {

    /* renamed from: a */
    private static Context f11452a = PushClientApplication.m18732r();

    /* renamed from: a */
    public static EnumC3114f m12697a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f11452a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? EnumC3114f.NoActive : EnumC3114f.m12699a(activeNetworkInfo.getType());
    }

    /* renamed from: b */
    public static String m12698b() {
        return ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getNetworkOperator();
    }
}
