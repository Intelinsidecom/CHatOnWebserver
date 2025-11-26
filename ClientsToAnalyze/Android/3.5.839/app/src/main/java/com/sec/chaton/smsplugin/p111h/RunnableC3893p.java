package com.sec.chaton.smsplugin.p111h;

import android.content.ContentValues;
import android.net.Uri;
import com.sec.common.CommonApplication;

/* compiled from: MmsUIUtils.java */
/* renamed from: com.sec.chaton.smsplugin.h.p */
/* loaded from: classes.dex */
final class RunnableC3893p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f14000a;

    /* renamed from: b */
    final /* synthetic */ ContentValues f14001b;

    RunnableC3893p(Uri uri, ContentValues contentValues) {
        this.f14000a = uri;
        this.f14001b = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        CommonApplication.m18732r().getContentResolver().update(this.f14000a, this.f14001b, null, null);
    }
}
