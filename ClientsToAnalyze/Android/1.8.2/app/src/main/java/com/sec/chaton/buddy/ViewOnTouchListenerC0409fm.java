package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fm */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0409fm implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1568a;

    ViewOnTouchListenerC0409fm(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1568a = specialBuddyProfileFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1568a.getString(R.string.special_buddy_button_see_more));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
