package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.o */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0800o implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3095a;

    ViewOnTouchListenerC0800o(AddBuddyFragment addBuddyFragment) {
        this.f3095a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3095a.getString(R.string.buddy_list_dialog_addbuddy_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
