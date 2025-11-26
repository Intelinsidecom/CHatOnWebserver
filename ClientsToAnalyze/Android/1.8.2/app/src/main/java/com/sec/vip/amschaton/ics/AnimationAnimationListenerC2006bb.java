package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bb */
/* loaded from: classes.dex */
class AnimationAnimationListenerC2006bb implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7288a;

    AnimationAnimationListenerC2006bb(AMSPlayerActivity aMSPlayerActivity) {
        this.f7288a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7288a.f7220w.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7288a.f7220w.setVisibility(8);
    }
}
