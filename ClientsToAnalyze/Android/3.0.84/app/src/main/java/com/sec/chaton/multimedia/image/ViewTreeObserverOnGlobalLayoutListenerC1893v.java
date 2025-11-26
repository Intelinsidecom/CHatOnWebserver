package com.sec.chaton.multimedia.image;

import android.view.ViewTreeObserver;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.v */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1893v implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f7184a;

    ViewTreeObserverOnGlobalLayoutListenerC1893v(ImagePagerFragment imagePagerFragment) {
        this.f7184a = imagePagerFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f7184a.f6953s != EnumC1455w.VIDEO && !this.f7184a.f6955u) {
            this.f7184a.f6947m.m7704a(this.f7184a.f6958x);
        }
    }
}
