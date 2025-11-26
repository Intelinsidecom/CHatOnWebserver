package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.aa */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0366aa implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1306a;

    ViewOnTouchListenerC0366aa(BuddyProfileActivity buddyProfileActivity) {
        this.f1306a = buddyProfileActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1306a.getString(R.string.menu_video_call));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
