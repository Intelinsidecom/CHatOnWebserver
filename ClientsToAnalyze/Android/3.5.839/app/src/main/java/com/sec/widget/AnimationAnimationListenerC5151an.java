package com.sec.widget;

import android.view.animation.Animation;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.an */
/* loaded from: classes.dex */
class AnimationAnimationListenerC5151an implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f18857a;

    AnimationAnimationListenerC5151an(TwIndexScrollView twIndexScrollView) {
        this.f18857a = twIndexScrollView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.f18857a.f18799H) {
            this.f18857a.f18799H = true;
        }
        if (this.f18857a.f18795D) {
            this.f18857a.m19687f();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (this.f18857a.f18795D) {
            if (this.f18857a.f18828z.getVisibility() == 4) {
                this.f18857a.f18828z.setVisibility(0);
            }
            this.f18857a.f18828z.startAnimation(this.f18857a.f18797F);
        }
    }
}
