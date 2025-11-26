package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aq */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1421aq implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5054a;

    AnimationAnimationListenerC1421aq(AMSPlayerActivity aMSPlayerActivity) {
        this.f5054a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5054a.f5006v.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5054a.f5006v.setVisibility(0);
        this.f5054a.f5009y = true;
    }
}
