package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bn */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0406bn implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1380a;

    ViewOnTouchListenerC0406bn(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1380a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1380a.getString(R.string.buddy_list_dialog_addbuddy_hint));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
