package com.sec.vip.amschaton.honeycomb;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aw */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1427aw implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5060a;

    AnimationAnimationListenerC1427aw(AMSPlayerActivity aMSPlayerActivity) {
        this.f5060a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5060a.f5006v.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5060a.f5006v.setVisibility(8);
        this.f5060a.f5009y = false;
    }
}
