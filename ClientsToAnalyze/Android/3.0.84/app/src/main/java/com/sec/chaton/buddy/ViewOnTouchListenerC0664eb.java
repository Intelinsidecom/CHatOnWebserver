package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.eb */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0664eb implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2885a;

    ViewOnTouchListenerC0664eb(BuddyInfoFragment buddyInfoFragment) {
        this.f2885a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2885a.getString(R.string.menu_call));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
