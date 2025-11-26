package com.sec.chaton.buddy;

import android.view.ViewTreeObserver;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.iv */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC0792iv implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f3084a;

    ViewTreeObserverOnGlobalLayoutListenerC0792iv(ViewProfileImage viewProfileImage) {
        this.f3084a = viewProfileImage;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f3084a.f2347c != null && this.f3084a.f2347c.getDrawable() != null) {
            this.f3084a.f2350f.m7704a(this.f3084a.f2347c);
        }
    }
}
