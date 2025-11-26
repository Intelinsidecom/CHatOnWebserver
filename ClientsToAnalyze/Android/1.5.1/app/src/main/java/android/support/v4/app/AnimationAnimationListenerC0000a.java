package android.support.v4.app;

import android.content.res.Resources;
import android.view.animation.Animation;

/* renamed from: android.support.v4.app.a */
/* loaded from: classes.dex */
class AnimationAnimationListenerC0000a implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ Fragment f24a;

    /* renamed from: b */
    final /* synthetic */ C0015p f25b;

    AnimationAnimationListenerC0000a(C0015p c0015p, Fragment fragment) {
        this.f25b = c0015p;
        this.f24a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) throws Resources.NotFoundException {
        if (this.f24a.mAnimatingAway != null) {
            this.f24a.mAnimatingAway = null;
            this.f25b.m81a(this.f24a, this.f24a.mStateAfterAnimating, 0, 0);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
