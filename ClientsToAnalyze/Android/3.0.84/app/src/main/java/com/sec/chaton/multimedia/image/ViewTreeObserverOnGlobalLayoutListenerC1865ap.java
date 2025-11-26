package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ap */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1865ap implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7104a;

    ViewTreeObserverOnGlobalLayoutListenerC1865ap(PostONImagePagerFragment postONImagePagerFragment) {
        this.f7104a = postONImagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f7104a.f7011K != this.f7104a.f7009I.getHeight() || this.f7104a.f7012L != this.f7104a.f7009I.getWidth()) {
            this.f7104a.f7011K = this.f7104a.f7009I.getHeight();
            this.f7104a.f7012L = this.f7104a.f7009I.getWidth();
            if (this.f7104a.f7030t.equals(PostONImagePagerFragment.f6997i)) {
                this.f7104a.f7024n.m7704a(this.f7104a.f7025o);
            }
        }
    }
}
