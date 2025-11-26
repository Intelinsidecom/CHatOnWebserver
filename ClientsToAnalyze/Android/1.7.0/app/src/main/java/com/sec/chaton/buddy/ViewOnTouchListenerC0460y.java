package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.y */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0460y implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1453a;

    ViewOnTouchListenerC0460y(BuddyProfileActivity buddyProfileActivity) {
        this.f1453a = buddyProfileActivity;
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
