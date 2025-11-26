package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bw */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0415bw implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1390a;

    ViewOnTouchListenerC0415bw(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1390a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1390a.getString(R.string.buddy_list_dialog_addbuddy_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
