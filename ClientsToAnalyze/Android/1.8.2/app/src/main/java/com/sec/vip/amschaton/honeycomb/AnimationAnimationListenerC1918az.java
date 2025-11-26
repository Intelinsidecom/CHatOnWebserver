package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.az */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1918az implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7056a;

    AnimationAnimationListenerC1918az(AMSPlayerActivity aMSPlayerActivity) {
        this.f7056a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7056a.f6991w.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7056a.f6991w.setVisibility(0);
    }
}
