package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ax */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0389ax implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1359a;

    ViewOnTouchListenerC0389ax(BuddyProfileActivity buddyProfileActivity) {
        this.f1359a = buddyProfileActivity;
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
