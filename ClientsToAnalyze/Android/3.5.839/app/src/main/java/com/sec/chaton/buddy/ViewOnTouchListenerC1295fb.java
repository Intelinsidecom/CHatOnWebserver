package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fb */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1295fb implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4831a;

    ViewOnTouchListenerC1295fb(BuddyInfoFragment buddyInfoFragment) {
        this.f4831a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4831a.getString(R.string.menu_button_start_chat));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
