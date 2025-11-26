package com.sec.widget;

import android.view.animation.Animation;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.bb */
/* loaded from: classes.dex */
class AnimationAnimationListenerC3661bb implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f13553a;

    AnimationAnimationListenerC3661bb(TwIndexScrollView twIndexScrollView) {
        this.f13553a = twIndexScrollView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.f13553a.f13432H) {
            this.f13553a.f13432H = true;
        }
        if (this.f13553a.f13428D) {
            this.f13553a.m13154f();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (this.f13553a.f13428D) {
            if (this.f13553a.f13461z.getVisibility() == 4) {
                this.f13553a.f13461z.setVisibility(0);
            }
            this.f13553a.f13461z.startAnimation(this.f13553a.f13430F);
        }
    }
}
