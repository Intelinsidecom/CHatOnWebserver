package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.fb */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0398fb implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1557a;

    ViewOnTouchListenerC0398fb(SpecialBuddyActivity specialBuddyActivity) {
        this.f1557a = specialBuddyActivity;
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
