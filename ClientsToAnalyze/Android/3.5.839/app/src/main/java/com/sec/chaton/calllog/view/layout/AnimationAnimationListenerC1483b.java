package com.sec.chaton.calllog.view.layout;

import android.view.animation.Animation;

/* compiled from: List_CallLog.java */
/* renamed from: com.sec.chaton.calllog.view.layout.b */
/* loaded from: classes.dex */
class AnimationAnimationListenerC1483b implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ float f5408a;

    /* renamed from: b */
    final /* synthetic */ int f5409b;

    /* renamed from: c */
    final /* synthetic */ List_CallLog f5410c;

    AnimationAnimationListenerC1483b(List_CallLog list_CallLog, float f, int i) {
        this.f5410c = list_CallLog;
        this.f5408a = f;
        this.f5409b = i;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5410c.mo7557a((int) this.f5408a);
        if (this.f5409b == 1) {
            this.f5410c.m7560b(1);
        } else if (this.f5409b == 0) {
            this.f5410c.m7560b(0);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
