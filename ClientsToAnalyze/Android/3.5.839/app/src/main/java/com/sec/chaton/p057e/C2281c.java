package com.sec.chaton.p057e;

import android.net.Uri;

/* compiled from: ChatON3rdAppContract.java */
/* renamed from: com.sec.chaton.e.c */
/* loaded from: classes.dex */
public class C2281c implements InterfaceC2239b {

    /* renamed from: a */
    public static final Uri f8184a = C2173a.f7803a.buildUpon().appendPath("appmanage").build();

    /* renamed from: a */
    public static Uri m10136a() {
        return f8184a.buildUpon().appendPath("full_message").build();
    }

    /* renamed from: b */
    public static Uri m10137b() {
        return f8184a.buildUpon().appendPath("simple_push_native_message").build();
    }
}
