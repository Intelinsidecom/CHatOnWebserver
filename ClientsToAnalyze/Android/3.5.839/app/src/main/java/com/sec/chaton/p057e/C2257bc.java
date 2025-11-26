package com.sec.chaton.p057e;

import android.net.Uri;

/* compiled from: ChatONContract2.java */
/* renamed from: com.sec.chaton.e.bc */
/* loaded from: classes.dex */
public class C2257bc implements InterfaceC2256bb {

    /* renamed from: a */
    public static final Uri f8039a = C2233au.f7978a.buildUpon().appendPath("download_item").build();

    /* renamed from: a */
    public static Uri m10121a(EnumC2258bd enumC2258bd) {
        return f8039a.buildUpon().appendPath(enumC2258bd.m10123a()).build();
    }

    /* renamed from: a */
    public static Uri m10120a() {
        return f8039a.buildUpon().appendPath("downloaded_item").build();
    }
}
