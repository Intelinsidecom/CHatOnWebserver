package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.an */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1863an implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7102a;

    ViewTreeObserverOnGlobalLayoutListenerC1863an(PostONImagePagerFragment postONImagePagerFragment) {
        this.f7102a = postONImagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f7102a.f7030t.equals(PostONImagePagerFragment.f6998j) || this.f7102a.f7030t.equals(PostONImagePagerFragment.f6997i)) {
            this.f7102a.f7024n.m7704a(this.f7102a.f7025o);
        }
    }
}
