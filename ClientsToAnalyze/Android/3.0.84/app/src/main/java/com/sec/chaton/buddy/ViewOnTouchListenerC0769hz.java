package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hz */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0769hz implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3039a;

    ViewOnTouchListenerC0769hz(SpecialBuddyFragment specialBuddyFragment) {
        this.f3039a = specialBuddyFragment;
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
