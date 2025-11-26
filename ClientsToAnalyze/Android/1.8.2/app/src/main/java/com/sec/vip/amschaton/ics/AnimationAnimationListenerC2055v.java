package com.sec.vip.amschaton.ics;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.v */
/* loaded from: classes.dex */
class AnimationAnimationListenerC2055v implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ View f7349a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7350b;

    AnimationAnimationListenerC2055v(AMSComposerActivity aMSComposerActivity, View view) {
        this.f7350b = aMSComposerActivity;
        this.f7349a = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f7349a.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }
}
