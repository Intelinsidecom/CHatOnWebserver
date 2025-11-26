package com.sec.vip.amschaton.ics;

import android.view.animation.Animation;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bf */
/* loaded from: classes.dex */
class AnimationAnimationListenerC2010bf implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7292a;

    AnimationAnimationListenerC2010bf(AMSPlayerActivity aMSPlayerActivity) {
        this.f7292a = aMSPlayerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7292a.f7206D.setVisibility(0);
        this.f7292a.f7221x.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7292a.f7206D.setVisibility(8);
        this.f7292a.f7221x.setVisibility(8);
        this.f7292a.f7223z = false;
    }
}
