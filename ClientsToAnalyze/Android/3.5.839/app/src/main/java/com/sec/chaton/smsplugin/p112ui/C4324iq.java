package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p110g.C3862h;
import com.sec.chaton.smsplugin.p110g.C3870p;

/* compiled from: SlideshowPresenter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.iq */
/* loaded from: classes.dex */
class C4324iq implements InterfaceC4118b {

    /* renamed from: a */
    final /* synthetic */ SlideshowPresenter f15727a;

    C4324iq(SlideshowPresenter slideshowPresenter) {
        this.f15727a = slideshowPresenter;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4118b
    /* renamed from: a */
    public void mo16341a(int i, int i2) {
        C3862h c3862hM14913d = ((C3870p) this.f15727a.mModel).m14913d();
        this.f15727a.mWidthTransformRatio = this.f15727a.getWidthTransformRatio(i, c3862hM14913d.m14793d());
        this.f15727a.mHeightTransformRatio = this.f15727a.getHeightTransformRatio(i2, c3862hM14913d.m14794e());
        float f = this.f15727a.mWidthTransformRatio > this.f15727a.mHeightTransformRatio ? this.f15727a.mWidthTransformRatio : this.f15727a.mHeightTransformRatio;
        this.f15727a.mWidthTransformRatio = f;
        this.f15727a.mHeightTransformRatio = f;
    }
}
