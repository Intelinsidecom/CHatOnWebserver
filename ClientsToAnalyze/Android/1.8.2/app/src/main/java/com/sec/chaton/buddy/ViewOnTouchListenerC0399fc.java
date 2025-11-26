package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.fc */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0399fc implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1558a;

    ViewOnTouchListenerC0399fc(SpecialBuddyActivity specialBuddyActivity) {
        this.f1558a = specialBuddyActivity;
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
