package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.x */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0459x implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1452a;

    ViewOnTouchListenerC0459x(BuddyProfileActivity buddyProfileActivity) {
        this.f1452a = buddyProfileActivity;
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
