package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.il */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1386il implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4990a;

    ViewOnTouchListenerC1386il(SpecialBuddyFragment specialBuddyFragment) {
        this.f4990a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4990a.getString(R.string.buddy_list_contextual_menu_follow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
