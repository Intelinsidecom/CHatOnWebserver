package com.sec.vip.amschaton;

import android.view.animation.Animation;

/* renamed from: com.sec.vip.amschaton.ai */
/* loaded from: classes.dex */
class AnimationAnimationListenerC0635ai implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4246a;

    AnimationAnimationListenerC0635ai(AMSPlayerActivity aMSPlayerActivity) {
        this.f4246a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4246a.f4089d.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
