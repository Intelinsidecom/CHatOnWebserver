package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bo */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0407bo implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1381a;

    ViewOnTouchListenerC0407bo(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1381a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1381a.getString(R.string.enter_samsung_account_id));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
