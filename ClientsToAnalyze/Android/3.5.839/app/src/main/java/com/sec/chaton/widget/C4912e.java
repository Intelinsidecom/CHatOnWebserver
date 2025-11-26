package com.sec.chaton.widget;

import android.animation.ValueAnimator;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.e */
/* loaded from: classes.dex */
class C4912e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ DynamicListView f17961a;

    C4912e(DynamicListView dynamicListView) {
        this.f17961a = dynamicListView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f17961a.invalidate();
    }
}
