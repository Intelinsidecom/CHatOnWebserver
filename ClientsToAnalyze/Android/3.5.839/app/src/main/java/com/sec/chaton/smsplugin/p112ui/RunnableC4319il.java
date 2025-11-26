package com.sec.chaton.smsplugin.p112ui;

import org.p146b.p147a.p148a.InterfaceC5237b;

/* compiled from: SlideshowActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.il */
/* loaded from: classes.dex */
class RunnableC4319il implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC5237b f15715a;

    /* renamed from: b */
    final /* synthetic */ SlideshowActivity f15716b;

    RunnableC4319il(SlideshowActivity slideshowActivity, InterfaceC5237b interfaceC5237b) {
        this.f15716b = slideshowActivity;
        this.f15715a = interfaceC5237b;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strMo14494b = this.f15715a.mo14494b();
        if (strMo14494b.equals("SimlDocumentEnd")) {
            this.f15716b.finish();
        } else if (strMo14494b.equals("SmilDocumentStart")) {
            this.f15716b.f15147a.show(50000);
        }
    }
}
