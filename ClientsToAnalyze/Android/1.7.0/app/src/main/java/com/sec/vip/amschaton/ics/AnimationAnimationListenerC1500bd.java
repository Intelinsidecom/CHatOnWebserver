package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bd */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1500bd implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5322a;

    AnimationAnimationListenerC1500bd(AMSPlayerActivity aMSPlayerActivity) {
        this.f5322a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5322a.f5235B.setVisibility(0);
        this.f5322a.f5250v.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5322a.f5235B.setVisibility(8);
        this.f5322a.f5250v.setVisibility(8);
        this.f5322a.f5252x = false;
    }
}
