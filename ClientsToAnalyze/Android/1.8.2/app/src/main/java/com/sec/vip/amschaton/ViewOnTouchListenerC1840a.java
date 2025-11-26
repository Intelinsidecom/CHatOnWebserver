package com.sec.vip.amschaton;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: AMSActionBarView.java */
/* renamed from: com.sec.vip.amschaton.a */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1840a implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AMSActionBarView f6765a;

    ViewOnTouchListenerC1840a(AMSActionBarView aMSActionBarView) {
        this.f6765a = aMSActionBarView;
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
