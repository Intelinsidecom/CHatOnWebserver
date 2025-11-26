package com.sec.chaton.smsplugin.p112ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Parcelable;
import com.sec.chaton.smsplugin.p102b.C3789h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dy */
/* loaded from: classes.dex */
class RunnableC4197dy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Parcelable[] f15525a;

    /* renamed from: b */
    final /* synthetic */ Handler f15526b;

    /* renamed from: c */
    final /* synthetic */ Runnable f15527c;

    /* renamed from: d */
    final /* synthetic */ ProgressDialog f15528d;

    /* renamed from: e */
    final /* synthetic */ PluginComposeMessageActivity f15529e;

    RunnableC4197dy(PluginComposeMessageActivity pluginComposeMessageActivity, Parcelable[] parcelableArr, Handler handler, Runnable runnable, ProgressDialog progressDialog) {
        this.f15529e = pluginComposeMessageActivity;
        this.f15525a = parcelableArr;
        this.f15526b = handler;
        this.f15527c = runnable;
        this.f15528d = progressDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C3789h c3789hM14305a = C3789h.m14305a(this.f15525a);
            this.f15526b.removeCallbacks(this.f15527c);
            this.f15528d.dismiss();
            this.f15526b.post(new RunnableC4198dz(this, c3789hM14305a));
        } catch (Throwable th) {
            this.f15526b.removeCallbacks(this.f15527c);
            this.f15528d.dismiss();
            throw th;
        }
    }
}
