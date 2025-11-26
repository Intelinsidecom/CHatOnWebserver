package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fh */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0404fh implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1563a;

    ViewOnTouchListenerC0404fh(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1563a = specialBuddyProfileFragment;
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
