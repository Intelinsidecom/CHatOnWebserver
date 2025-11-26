package com.sec.chaton.chat;

import android.view.animation.Animation;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.l */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1790l implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6701a;

    AnimationAnimationListenerC1790l(ChatFragment chatFragment) {
        this.f6701a = chatFragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation.equals(this.f6701a.f5720eI)) {
            this.f6701a.f5719eH.setVisibility(8);
        }
    }
}
