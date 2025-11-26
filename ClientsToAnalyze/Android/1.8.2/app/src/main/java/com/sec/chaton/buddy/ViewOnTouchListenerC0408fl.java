package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fl */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0408fl implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1567a;

    ViewOnTouchListenerC0408fl(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1567a = specialBuddyProfileFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1567a.getString(R.string.menu_button_start_chat));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
