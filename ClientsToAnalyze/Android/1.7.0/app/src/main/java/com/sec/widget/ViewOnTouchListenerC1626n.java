package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: GeneralHeaderView.java */
/* renamed from: com.sec.widget.n */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1626n implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ GeneralHeaderView f5745a;

    ViewOnTouchListenerC1626n(GeneralHeaderView generalHeaderView) {
        this.f5745a = generalHeaderView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
