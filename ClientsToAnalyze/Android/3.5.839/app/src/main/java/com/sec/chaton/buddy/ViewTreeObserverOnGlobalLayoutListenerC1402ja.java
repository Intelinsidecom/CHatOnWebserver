package com.sec.chaton.buddy;

import android.view.ViewTreeObserver;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.ja */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1402ja implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f5033a;

    ViewTreeObserverOnGlobalLayoutListenerC1402ja(ViewProfileImage viewProfileImage) {
        this.f5033a = viewProfileImage;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f5033a.f4197p != null && this.f5033a.f4197p.getDrawable() != null) {
            this.f5033a.f4200s.m11930a(this.f5033a.f4197p);
        }
    }
}
