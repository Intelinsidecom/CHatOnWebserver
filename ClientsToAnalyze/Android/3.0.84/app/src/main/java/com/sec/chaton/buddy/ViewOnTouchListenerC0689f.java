package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0689f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2911a;

    ViewOnTouchListenerC0689f(AddBuddyFragment addBuddyFragment) {
        this.f2911a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2911a.getString(R.string.addbuddy_enter_samsung_account));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
