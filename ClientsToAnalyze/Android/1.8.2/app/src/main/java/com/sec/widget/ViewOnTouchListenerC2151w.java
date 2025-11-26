package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: GeneralHeaderView.java */
/* renamed from: com.sec.widget.w */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2151w implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ GeneralHeaderView f7844a;

    ViewOnTouchListenerC2151w(GeneralHeaderView generalHeaderView) {
        this.f7844a = generalHeaderView;
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
