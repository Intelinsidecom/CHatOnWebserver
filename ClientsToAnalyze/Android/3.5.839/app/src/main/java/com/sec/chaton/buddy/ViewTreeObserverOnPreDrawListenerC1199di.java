package com.sec.chaton.buddy;

import android.view.ViewTreeObserver;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.di */
/* loaded from: classes.dex */
class ViewTreeObserverOnPreDrawListenerC1199di implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4429a;

    ViewTreeObserverOnPreDrawListenerC1199di(BuddyFragment buddyFragment) {
        this.f4429a = buddyFragment;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (!this.f4429a.f3731cK) {
            this.f4429a.f3732cL = this.f4429a.f3734cN.getHeight();
            this.f4429a.f3733cM = this.f4429a.f3734cN.getWidth();
            C4904y.m18639b("[EventBanner] addOnPreDrawListener " + this.f4429a.f3733cM + ", " + this.f4429a.f3732cL, BuddyFragment.f3576a);
            this.f4429a.f3731cK = true;
            this.f4429a.f3734cN.setVisibility(8);
            this.f4429a.m6526g(true);
        }
        return true;
    }
}
