package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;
import com.sec.chaton.R;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dt */
/* loaded from: classes.dex */
class RunnableC4192dt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f15518a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15519b;

    RunnableC4192dt(PluginComposeMessageActivity pluginComposeMessageActivity, int i) {
        this.f15519b = pluginComposeMessageActivity;
        this.f15518a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15519b.m15934a(this.f15518a, R.string.type_picture, (Uri) null);
        this.f15519b.mo14475a((Uri) null, (String) null);
    }
}
