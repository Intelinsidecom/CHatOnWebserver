package android.support.v4.app;

import android.view.animation.Animation;

/* compiled from: FragmentManager.java */
/* renamed from: android.support.v4.app.ab */
/* loaded from: classes.dex */
class AnimationAnimationListenerC0016ab implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ Fragment f91a;

    /* renamed from: b */
    final /* synthetic */ C0071y f92b;

    AnimationAnimationListenerC0016ab(C0071y c0071y, Fragment fragment) {
        this.f92b = c0071y;
        this.f91a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f91a.mAnimatingAway != null) {
            this.f91a.mAnimatingAway = null;
            this.f92b.m203a(this.f91a, this.f91a.mStateAfterAnimating, 0, 0, false);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
