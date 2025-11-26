package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.v */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0457v implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1450a;

    ViewOnTouchListenerC0457v(BuddyProfileActivity buddyProfileActivity) {
        this.f1450a = buddyProfileActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1450a.getString(R.string.menu_call));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
