package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.at */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1424at implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5057a;

    AnimationAnimationListenerC1424at(AMSPlayerActivity aMSPlayerActivity) {
        this.f5057a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5057a.f5005u.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5057a.f5005u.setVisibility(0);
    }
}
