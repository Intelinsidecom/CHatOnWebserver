package com.sec.vip.amschaton.ics;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.w */
/* loaded from: classes.dex */
class AnimationAnimationListenerC2056w implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ View f7351a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7352b;

    AnimationAnimationListenerC2056w(AMSComposerActivity aMSComposerActivity, View view) {
        this.f7352b = aMSComposerActivity;
        this.f7351a = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f7351a.setVisibility(8);
    }
}
