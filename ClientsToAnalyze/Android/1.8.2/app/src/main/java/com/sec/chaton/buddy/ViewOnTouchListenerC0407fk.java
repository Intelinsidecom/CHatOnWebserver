package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fk */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0407fk implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1566a;

    ViewOnTouchListenerC0407fk(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1566a = specialBuddyProfileFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1566a.getString(R.string.buddy_profile_button_addbuddy));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
