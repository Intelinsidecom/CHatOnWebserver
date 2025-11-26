package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.e */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0662e implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2881a;

    ViewOnTouchListenerC0662e(AddBuddyFragment addBuddyFragment) {
        this.f2881a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2881a.getString(R.string.buddy_list_dialog_addbuddy_hint));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
