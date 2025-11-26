package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.eu */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1287eu implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4820a;

    ViewOnTouchListenerC1287eu(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4820a = buddyGroupProfileFragment;
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
