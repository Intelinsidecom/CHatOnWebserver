package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.u */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0456u implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1449a;

    ViewOnTouchListenerC0456u(BuddyProfileActivity buddyProfileActivity) {
        this.f1449a = buddyProfileActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1449a.getString(R.string.message_dont_preview));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
