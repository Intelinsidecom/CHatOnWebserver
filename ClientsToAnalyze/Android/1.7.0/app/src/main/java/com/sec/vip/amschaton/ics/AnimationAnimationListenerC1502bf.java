package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bf */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1502bf implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5324a;

    AnimationAnimationListenerC1502bf(AMSPlayerActivity aMSPlayerActivity) {
        this.f5324a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5324a.f5235B.setVisibility(0);
        this.f5324a.f5250v.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5324a.f5235B.setVisibility(0);
        this.f5324a.f5250v.setVisibility(0);
        this.f5324a.f5252x = true;
    }
}
