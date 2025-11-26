package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.an */
/* loaded from: classes.dex */
final class ViewOnTouchListenerC0529an implements View.OnTouchListener {
    ViewOnTouchListenerC0529an() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(GlobalApplication.m6451b().getString(R.string.buddy_list_dialog_addbuddy_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
