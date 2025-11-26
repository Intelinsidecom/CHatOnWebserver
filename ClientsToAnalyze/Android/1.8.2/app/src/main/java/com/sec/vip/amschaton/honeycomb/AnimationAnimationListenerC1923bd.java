package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bd */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1923bd implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7061a;

    AnimationAnimationListenerC1923bd(AMSPlayerActivity aMSPlayerActivity) {
        this.f7061a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7061a.f6992x.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7061a.f6992x.setVisibility(8);
        this.f7061a.f6973A = false;
    }
}
