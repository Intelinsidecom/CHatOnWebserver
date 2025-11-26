package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ib */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0772ib implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3043a;

    ViewOnTouchListenerC0772ib(SpecialBuddyFragment specialBuddyFragment) {
        this.f3043a = specialBuddyFragment;
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
