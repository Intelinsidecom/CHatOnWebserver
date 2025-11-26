package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentValues;
import android.net.Uri;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fw */
/* loaded from: classes.dex */
class RunnableC4249fw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15604a;

    /* renamed from: b */
    final /* synthetic */ ContentValues f15605b;

    /* renamed from: c */
    final /* synthetic */ PluginComposeMessageActivity f15606c;

    RunnableC4249fw(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri, ContentValues contentValues) {
        this.f15606c = pluginComposeMessageActivity;
        this.f15604a = uri;
        this.f15605b = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15606c.getContentResolver().update(this.f15604a, this.f15605b, null, null);
    }
}
