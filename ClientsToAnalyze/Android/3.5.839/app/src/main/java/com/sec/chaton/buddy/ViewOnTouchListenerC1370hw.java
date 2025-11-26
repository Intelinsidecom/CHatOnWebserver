package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hw */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1370hw implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4970a;

    ViewOnTouchListenerC1370hw(SpecialBuddyFragment specialBuddyFragment) {
        this.f4970a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4970a.getString(R.string.buddy_list_contextual_menu_unfollow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
