package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fd */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1297fd implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4833a;

    ViewOnTouchListenerC1297fd(BuddyInfoFragment buddyInfoFragment) {
        this.f4833a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4833a.getString(R.string.menu_call));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
