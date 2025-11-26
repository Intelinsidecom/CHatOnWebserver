package com.sec.chaton.p027e;

import android.net.Uri;

/* compiled from: ChatON3rdAppContract.java */
/* renamed from: com.sec.chaton.e.c */
/* loaded from: classes.dex */
public class C1435c implements InterfaceC1409b {

    /* renamed from: a */
    public static final Uri f5363a = C1350a.f5088a.buildUpon().appendPath("appmanage").build();

    /* renamed from: a */
    public static Uri m6291a() {
        return f5363a.buildUpon().appendPath("full_message").build();
    }
}
