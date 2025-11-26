package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.g */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1320g implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4856a;

    ViewOnTouchListenerC1320g(AddBuddyFragment addBuddyFragment) {
        this.f4856a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4856a.getString(R.string.buddy_list_dialog_addbuddy_hint));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
