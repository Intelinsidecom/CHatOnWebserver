package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fr */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1311fr implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4847a;

    ViewOnTouchListenerC1311fr(BuddyProfileFragment buddyProfileFragment) {
        this.f4847a = buddyProfileFragment;
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
