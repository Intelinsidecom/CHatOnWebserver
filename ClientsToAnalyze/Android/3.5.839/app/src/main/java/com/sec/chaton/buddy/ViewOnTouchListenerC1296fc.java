package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fc */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1296fc implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4832a;

    ViewOnTouchListenerC1296fc(BuddyInfoFragment buddyInfoFragment) {
        this.f4832a = buddyInfoFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4832a.getString(R.string.chat_send_sms));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
