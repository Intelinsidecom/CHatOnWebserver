package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ec */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0665ec implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2886a;

    ViewOnTouchListenerC0665ec(BuddyInfoFragment buddyInfoFragment) {
        this.f2886a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2886a.getString(R.string.media_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
