package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.x */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1895x implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f7186a;

    ViewTreeObserverOnGlobalLayoutListenerC1895x(ImagePagerFragment imagePagerFragment) {
        this.f7186a = imagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f7186a.f6953s != EnumC1455w.VIDEO && !this.f7186a.f6955u) {
            this.f7186a.f6947m.m7704a(this.f7186a.f6948n);
        }
    }
}
