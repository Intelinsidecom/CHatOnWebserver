package com.sec.chaton.smsplugin.provider;

import android.net.Uri;

/* compiled from: PluginTelephony.java */
/* renamed from: com.sec.chaton.smsplugin.provider.w */
/* loaded from: classes.dex */
public final class C3965w implements InterfaceC3966x {

    /* renamed from: f */
    private static final String[] f14271f = {"_id"};

    /* renamed from: g */
    private static final Uri f14272g = Uri.parse("content://mms-sms/threadID");

    /* renamed from: h */
    private static final Uri f14273h = Uri.parse("content://security_mms-sms/threadID");

    /* renamed from: a */
    public static final Uri f14266a = Uri.withAppendedPath(C3961s.f14255a, "conversations");

    /* renamed from: b */
    public static final Uri f14267b = Uri.withAppendedPath(f14266a, "obsolete");

    /* renamed from: c */
    public static final Uri f14268c = Uri.withAppendedPath(C3961s.f14255a, "cmas");

    /* renamed from: d */
    public static final Uri f14269d = Uri.withAppendedPath(C3961s.f14255a, "reply_all");

    /* renamed from: e */
    public static final Uri f14270e = Uri.withAppendedPath(C3961s.f14255a, "last_msg_time");
}
