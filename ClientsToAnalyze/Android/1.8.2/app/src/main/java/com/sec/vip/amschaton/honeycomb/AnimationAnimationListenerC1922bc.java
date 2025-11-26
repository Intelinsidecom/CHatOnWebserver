package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bc */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1922bc implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7060a;

    AnimationAnimationListenerC1922bc(AMSPlayerActivity aMSPlayerActivity) {
        this.f7060a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7060a.f6992x.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7060a.f6992x.setVisibility(0);
        this.f7060a.f6973A = true;
    }
}
