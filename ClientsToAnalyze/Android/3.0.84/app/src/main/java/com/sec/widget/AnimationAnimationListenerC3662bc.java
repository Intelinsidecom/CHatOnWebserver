package com.sec.widget;

import android.view.animation.Animation;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.bc */
/* loaded from: classes.dex */
class AnimationAnimationListenerC3662bc implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f13554a;

    AnimationAnimationListenerC3662bc(TwIndexScrollView twIndexScrollView) {
        this.f13554a = twIndexScrollView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f13554a.f13432H) {
            this.f13554a.f13432H = false;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
