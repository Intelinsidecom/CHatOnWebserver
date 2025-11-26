package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.InterfaceC3860f;

/* compiled from: SlideshowEditActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.in */
/* loaded from: classes.dex */
class C4321in implements InterfaceC3860f {

    /* renamed from: a */
    final /* synthetic */ SlideshowEditActivity f15720a;

    C4321in(SlideshowEditActivity slideshowEditActivity) {
        this.f15720a = slideshowEditActivity;
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3860f
    public void onModelChanged(C3866l c3866l, boolean z) {
        synchronized (this.f15720a) {
            this.f15720a.f15161h = true;
        }
        this.f15720a.setResult(-1, this.f15720a.f15160g);
        this.f15720a.m16238d();
    }
}
