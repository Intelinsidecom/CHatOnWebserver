package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ie */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0775ie implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3046a;

    ViewOnTouchListenerC0775ie(SpecialBuddyFragment specialBuddyFragment) {
        this.f3046a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3046a.getString(R.string.buddy_profile_button_addbuddy));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
