package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.z */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0461z implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1454a;

    ViewOnTouchListenerC0461z(BuddyProfileActivity buddyProfileActivity) {
        this.f1454a = buddyProfileActivity;
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
