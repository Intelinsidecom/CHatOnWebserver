package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;
import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.w */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2863w implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10505a;

    ViewTreeObserverOnGlobalLayoutListenerC2863w(ImagePagerFragment imagePagerFragment) {
        this.f10505a = imagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f10505a.f10257s != EnumC2214ab.VIDEO && !this.f10505a.f10259u) {
            this.f10505a.f10251m.m11930a(this.f10505a.f10262x);
        }
    }
}
