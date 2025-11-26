package com.sec.chaton.p027e;

import android.net.Uri;

/* compiled from: ChatONContract2.java */
/* renamed from: com.sec.chaton.e.ap */
/* loaded from: classes.dex */
public class C1398ap implements InterfaceC1397ao {

    /* renamed from: a */
    public static final Uri f5204a = C1392aj.f5201a.buildUpon().appendPath("download_item").build();

    /* renamed from: a */
    public static Uri m6249a(EnumC1399aq enumC1399aq) {
        return f5204a.buildUpon().appendPath(enumC1399aq.m6252a()).build();
    }

    /* renamed from: a */
    public static Uri m6250a(String str) {
        return f5204a.buildUpon().appendPath(EnumC1399aq.Font.m6252a()).appendPath("join_font_filter").appendPath(str).build();
    }
}
