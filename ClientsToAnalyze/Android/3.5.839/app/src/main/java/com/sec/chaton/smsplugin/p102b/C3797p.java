package com.sec.chaton.smsplugin.p102b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

/* compiled from: RecipientIdCache.java */
/* renamed from: com.sec.chaton.smsplugin.b.p */
/* loaded from: classes.dex */
class C3797p extends Thread {

    /* renamed from: a */
    final /* synthetic */ ContentResolver f13620a;

    /* renamed from: b */
    final /* synthetic */ Uri f13621b;

    /* renamed from: c */
    final /* synthetic */ ContentValues f13622c;

    /* renamed from: d */
    final /* synthetic */ StringBuilder f13623d;

    /* renamed from: e */
    final /* synthetic */ C3795n f13624e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3797p(C3795n c3795n, String str, ContentResolver contentResolver, Uri uri, ContentValues contentValues, StringBuilder sb) {
        super(str);
        this.f13624e = c3795n;
        this.f13620a = contentResolver;
        this.f13621b = uri;
        this.f13622c = contentValues;
        this.f13623d = sb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13620a.update(this.f13621b, this.f13622c, this.f13623d.toString(), null);
    }
}
