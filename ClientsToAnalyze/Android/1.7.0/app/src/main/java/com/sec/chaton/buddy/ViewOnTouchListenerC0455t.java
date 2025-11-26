package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.t */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0455t implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1448a;

    ViewOnTouchListenerC0455t(BuddyProfileActivity buddyProfileActivity) {
        this.f1448a = buddyProfileActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1448a.getString(R.string.media_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
