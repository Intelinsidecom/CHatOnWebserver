package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.fa */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0397fa implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1556a;

    ViewOnTouchListenerC0397fa(SpecialBuddyActivity specialBuddyActivity) {
        this.f1556a = specialBuddyActivity;
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
