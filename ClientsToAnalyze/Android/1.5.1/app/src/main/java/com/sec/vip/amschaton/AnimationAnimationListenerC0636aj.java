package com.sec.vip.amschaton;

import android.view.animation.Animation;

/* renamed from: com.sec.vip.amschaton.aj */
/* loaded from: classes.dex */
class AnimationAnimationListenerC0636aj implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4247a;

    AnimationAnimationListenerC0636aj(AMSPlayerActivity aMSPlayerActivity) {
        this.f4247a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4247a.f4089d.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
