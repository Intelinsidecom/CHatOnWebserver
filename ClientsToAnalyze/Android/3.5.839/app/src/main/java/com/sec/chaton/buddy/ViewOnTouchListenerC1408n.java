package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.n */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1408n implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5042a;

    ViewOnTouchListenerC1408n(AddBuddyFragment addBuddyFragment) {
        this.f5042a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f5042a.getString(R.string.buddy_add_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
