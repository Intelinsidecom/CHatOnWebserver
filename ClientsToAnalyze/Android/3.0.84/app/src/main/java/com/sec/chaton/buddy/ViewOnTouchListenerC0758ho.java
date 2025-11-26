package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ho */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0758ho implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3025a;

    ViewOnTouchListenerC0758ho(SpecialBuddyFragment specialBuddyFragment) {
        this.f3025a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3025a.getString(R.string.buddy_list_contextual_menu_unfollow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
