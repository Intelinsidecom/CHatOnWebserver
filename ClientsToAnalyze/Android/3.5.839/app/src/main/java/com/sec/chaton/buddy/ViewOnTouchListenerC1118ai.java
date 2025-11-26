package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ai */
/* loaded from: classes.dex */
final class ViewOnTouchListenerC1118ai implements View.OnTouchListener {
    ViewOnTouchListenerC1118ai() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(GlobalApplication.m10283b().getString(R.string.buddy_add_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
