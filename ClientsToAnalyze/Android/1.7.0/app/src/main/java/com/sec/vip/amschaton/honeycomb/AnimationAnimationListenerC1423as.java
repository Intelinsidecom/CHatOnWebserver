package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.as */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1423as implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5056a;

    AnimationAnimationListenerC1423as(AMSPlayerActivity aMSPlayerActivity) {
        this.f5056a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5056a.f5005u.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5056a.f5005u.setVisibility(8);
    }
}
