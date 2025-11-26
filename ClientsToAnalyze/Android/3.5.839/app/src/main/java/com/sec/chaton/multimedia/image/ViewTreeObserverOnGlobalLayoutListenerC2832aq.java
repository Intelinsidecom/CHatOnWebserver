package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.aq */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2832aq implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f10413a;

    ViewTreeObserverOnGlobalLayoutListenerC2832aq(PostONImagePagerFragment postONImagePagerFragment) {
        this.f10413a = postONImagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f10413a.f10336t.equals(PostONImagePagerFragment.f10305j) || this.f10413a.f10336t.equals(PostONImagePagerFragment.f10304i)) {
            this.f10413a.f10330n.m11930a(this.f10413a.f10331o);
        }
    }
}
