package com.sec.chaton.widget;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.d */
/* loaded from: classes.dex */
class ViewTreeObserverOnPreDrawListenerC4911d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ ViewTreeObserver f17956a;

    /* renamed from: b */
    final /* synthetic */ long f17957b;

    /* renamed from: c */
    final /* synthetic */ int f17958c;

    /* renamed from: d */
    final /* synthetic */ int f17959d;

    /* renamed from: e */
    final /* synthetic */ DynamicListView f17960e;

    ViewTreeObserverOnPreDrawListenerC4911d(DynamicListView dynamicListView, ViewTreeObserver viewTreeObserver, long j, int i, int i2) {
        this.f17960e = dynamicListView;
        this.f17956a = viewTreeObserver;
        this.f17957b = j;
        this.f17958c = i;
        this.f17959d = i2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f17956a.removeOnPreDrawListener(this);
        View viewM18695a = this.f17960e.m18695a(this.f17957b);
        DynamicListView.m18673b(this.f17960e, this.f17958c);
        int top = this.f17959d - viewM18695a.getTop();
        if (DynamicListView.m18686e()) {
            viewM18695a.setTranslationY(top);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewM18695a, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            objectAnimatorOfFloat.setDuration(150L);
            objectAnimatorOfFloat.start();
        }
        return true;
    }
}
