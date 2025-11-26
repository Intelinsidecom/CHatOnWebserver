package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.as */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2834as implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f10415a;

    ViewTreeObserverOnGlobalLayoutListenerC2834as(PostONImagePagerFragment postONImagePagerFragment) {
        this.f10415a = postONImagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f10415a.f10317J != this.f10415a.f10316I.getHeight() || this.f10415a.f10318K != this.f10415a.f10316I.getWidth()) {
            this.f10415a.f10317J = this.f10415a.f10316I.getHeight();
            this.f10415a.f10318K = this.f10415a.f10316I.getWidth();
            if (this.f10415a.f10336t.equals(PostONImagePagerFragment.f10304i)) {
                this.f10415a.f10330n.m11930a(this.f10415a.f10331o);
            }
        }
    }
}
