package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.C3869o;

/* compiled from: SlideshowPresenter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ir */
/* loaded from: classes.dex */
class RunnableC4325ir implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4315ih f15728a;

    /* renamed from: b */
    final /* synthetic */ C3866l f15729b;

    /* renamed from: c */
    final /* synthetic */ SlideshowPresenter f15730c;

    RunnableC4325ir(SlideshowPresenter slideshowPresenter, InterfaceC4315ih interfaceC4315ih, C3866l c3866l) {
        this.f15730c = slideshowPresenter;
        this.f15728a = interfaceC4315ih;
        this.f15729b = c3866l;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15730c.presentSlide(this.f15728a, (C3869o) this.f15729b);
    }
}
