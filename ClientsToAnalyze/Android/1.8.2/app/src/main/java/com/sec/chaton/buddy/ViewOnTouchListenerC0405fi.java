package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fi */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0405fi implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1564a;

    ViewOnTouchListenerC0405fi(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1564a = specialBuddyProfileFragment;
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
