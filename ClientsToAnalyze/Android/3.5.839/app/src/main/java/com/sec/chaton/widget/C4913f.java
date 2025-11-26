package com.sec.chaton.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.f */
/* loaded from: classes.dex */
class C4913f extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ View f17962a;

    /* renamed from: b */
    final /* synthetic */ DynamicListView f17963b;

    C4913f(DynamicListView dynamicListView, View view) {
        this.f17963b = dynamicListView;
        this.f17962a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f17963b.setEnabled(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f17963b.f17905m = -1L;
        this.f17963b.f17906n = -1L;
        this.f17963b.f17907o = -1L;
        this.f17962a.setVisibility(0);
        this.f17963b.f17908p = null;
        this.f17963b.setEnabled(true);
        this.f17963b.invalidate();
    }
}
