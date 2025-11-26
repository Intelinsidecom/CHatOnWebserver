package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bh */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1504bh implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5326a;

    AnimationAnimationListenerC1504bh(AMSPlayerActivity aMSPlayerActivity) {
        this.f5326a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f5326a.f5249u.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5326a.f5249u.setVisibility(8);
    }
}
