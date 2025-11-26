package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bd */
/* loaded from: classes.dex */
class AnimationAnimationListenerC2008bd implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7290a;

    AnimationAnimationListenerC2008bd(AMSPlayerActivity aMSPlayerActivity) {
        this.f7290a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7290a.f7206D.setVisibility(0);
        this.f7290a.f7221x.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7290a.f7206D.setVisibility(0);
        this.f7290a.f7221x.setVisibility(0);
        this.f7290a.f7223z = true;
    }
}
