package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bg */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1503bg implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5325a;

    AnimationAnimationListenerC1503bg(AMSPlayerActivity aMSPlayerActivity) {
        this.f5325a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5325a.f5249u.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5325a.f5249u.setVisibility(0);
    }
}
