package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ee */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0667ee implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2888a;

    ViewOnTouchListenerC0667ee(BuddyInfoFragment buddyInfoFragment) {
        this.f2888a = buddyInfoFragment;
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
