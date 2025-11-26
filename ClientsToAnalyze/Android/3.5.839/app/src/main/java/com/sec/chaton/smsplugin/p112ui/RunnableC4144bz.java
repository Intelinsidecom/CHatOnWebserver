package com.sec.chaton.smsplugin.p112ui;

import android.widget.Toast;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bz */
/* loaded from: classes.dex */
class RunnableC4144bz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15425a;

    /* renamed from: b */
    private final String f15426b;

    public RunnableC4144bz(C4132bn c4132bn, String str) {
        this.f15425a = c4132bn;
        this.f15426b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15426b != null) {
            Toast.makeText(this.f15425a.f15387c, this.f15426b, 0).show();
        }
    }
}
