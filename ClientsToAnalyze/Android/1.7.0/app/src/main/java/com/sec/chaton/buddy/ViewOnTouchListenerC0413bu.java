package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bu */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0413bu implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1387a;

    ViewOnTouchListenerC0413bu(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1387a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1387a.getString(R.string.results));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
