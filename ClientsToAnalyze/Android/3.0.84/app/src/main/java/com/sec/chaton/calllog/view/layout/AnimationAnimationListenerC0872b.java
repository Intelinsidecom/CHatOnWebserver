package com.sec.chaton.calllog.view.layout;

import android.view.animation.Animation;

/* compiled from: List_CallLog.java */
/* renamed from: com.sec.chaton.calllog.view.layout.b */
/* loaded from: classes.dex */
class AnimationAnimationListenerC0872b implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ float f3463a;

    /* renamed from: b */
    final /* synthetic */ int f3464b;

    /* renamed from: c */
    final /* synthetic */ List_CallLog f3465c;

    AnimationAnimationListenerC0872b(List_CallLog list_CallLog, float f, int i) {
        this.f3465c = list_CallLog;
        this.f3463a = f;
        this.f3464b = i;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f3465c.mo4403a((int) this.f3463a);
        if (this.f3464b == 1) {
            this.f3465c.m4406b(1);
        } else if (this.f3464b == 0) {
            this.f3465c.m4406b(0);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
