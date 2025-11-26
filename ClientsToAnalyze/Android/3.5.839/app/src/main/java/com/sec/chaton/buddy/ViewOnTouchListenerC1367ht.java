package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ht */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1367ht implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4967a;

    ViewOnTouchListenerC1367ht(SpecialBuddyFragment specialBuddyFragment) {
        this.f4967a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4967a.getString(R.string.menu_button_start_chat));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
