package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentValues;
import android.net.Uri;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bo */
/* loaded from: classes.dex */
class RunnableC4133bo implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15403a;

    /* renamed from: b */
    final /* synthetic */ ContentValues f15404b;

    /* renamed from: c */
    final /* synthetic */ C4132bn f15405c;

    @Override // java.lang.Runnable
    public void run() {
        this.f15405c.f15387c.getContentResolver().update(this.f15403a, this.f15404b, null, null);
    }
}
