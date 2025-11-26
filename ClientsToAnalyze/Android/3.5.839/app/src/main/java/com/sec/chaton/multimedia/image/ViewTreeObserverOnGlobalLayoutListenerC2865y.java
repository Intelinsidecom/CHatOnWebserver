package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;
import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.y */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2865y implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10507a;

    ViewTreeObserverOnGlobalLayoutListenerC2865y(ImagePagerFragment imagePagerFragment) {
        this.f10507a = imagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f10507a.f10257s != EnumC2214ab.VIDEO && !this.f10507a.f10259u) {
            this.f10507a.f10251m.m11930a(this.f10507a.f10252n);
        }
    }
}
