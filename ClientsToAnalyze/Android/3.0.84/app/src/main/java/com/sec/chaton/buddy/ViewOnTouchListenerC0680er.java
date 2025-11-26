package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.er */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0680er implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2902a;

    ViewOnTouchListenerC0680er(BuddyProfileFragment buddyProfileFragment) {
        this.f2902a = buddyProfileFragment;
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
