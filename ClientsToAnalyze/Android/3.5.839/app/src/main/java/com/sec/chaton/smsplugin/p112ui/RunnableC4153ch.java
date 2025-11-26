package com.sec.chaton.smsplugin.p112ui;

import com.sec.google.android.p134a.p135a.C5094q;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ch */
/* loaded from: classes.dex */
class RunnableC4153ch implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5094q f15455a;

    /* renamed from: b */
    final /* synthetic */ RunnableC4152cg f15456b;

    RunnableC4153ch(RunnableC4152cg runnableC4152cg, C5094q c5094q) {
        this.f15456b = runnableC4152cg;
        this.f15455a = c5094q;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15456b.f15453e != null) {
            this.f15456b.f15453e.mo16448a(this.f15455a, this.f15456b.f15454f);
        }
    }
}
