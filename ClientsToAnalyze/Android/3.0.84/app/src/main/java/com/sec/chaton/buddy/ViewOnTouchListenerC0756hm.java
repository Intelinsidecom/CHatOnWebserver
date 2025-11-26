package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hm */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0756hm implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3023a;

    ViewOnTouchListenerC0756hm(SpecialBuddyFragment specialBuddyFragment) {
        this.f3023a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3023a.getString(R.string.menu_button_start_chat));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
