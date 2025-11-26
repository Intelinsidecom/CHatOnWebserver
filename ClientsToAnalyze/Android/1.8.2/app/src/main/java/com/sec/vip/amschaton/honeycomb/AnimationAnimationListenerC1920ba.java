package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ba */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1920ba implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7058a;

    AnimationAnimationListenerC1920ba(AMSPlayerActivity aMSPlayerActivity) {
        this.f7058a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7058a.f6991w.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7058a.f6991w.setVisibility(8);
    }
}
