package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dx */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0659dx implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2878a;

    ViewOnTouchListenerC0659dx(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2878a = buddyGroupProfileFragment;
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
