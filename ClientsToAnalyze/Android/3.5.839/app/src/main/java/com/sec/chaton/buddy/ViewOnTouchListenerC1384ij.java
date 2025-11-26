package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ij */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1384ij implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4988a;

    ViewOnTouchListenerC1384ij(SpecialBuddyFragment specialBuddyFragment) {
        this.f4988a = specialBuddyFragment;
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
