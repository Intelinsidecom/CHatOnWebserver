package com.sec.widget;

import android.view.animation.Animation;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.ao */
/* loaded from: classes.dex */
class AnimationAnimationListenerC5152ao implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f18858a;

    AnimationAnimationListenerC5152ao(TwIndexScrollView twIndexScrollView) {
        this.f18858a = twIndexScrollView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f18858a.f18799H) {
            this.f18858a.f18799H = false;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
