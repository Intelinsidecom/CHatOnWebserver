package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bl */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0404bl implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1378a;

    ViewOnTouchListenerC0404bl(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1378a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1378a.getString(R.string.enter_samsung_account_id));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
