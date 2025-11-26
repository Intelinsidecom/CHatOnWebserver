package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eh */
/* loaded from: classes.dex */
class RunnableC4207eh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f15549a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f15550b;

    /* renamed from: c */
    final /* synthetic */ String f15551c;

    /* renamed from: d */
    final /* synthetic */ PluginComposeMessageActivity f15552d;

    RunnableC4207eh(PluginComposeMessageActivity pluginComposeMessageActivity, int i, ArrayList arrayList, String str) {
        this.f15552d = pluginComposeMessageActivity;
        this.f15549a = i;
        this.f15550b = arrayList;
        this.f15551c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f15549a) {
                this.f15552d.m15967a(this.f15551c, (Uri) ((Parcelable) this.f15550b.get(i2)), true);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
