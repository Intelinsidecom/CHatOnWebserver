package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ab */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0367ab implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1307a;

    ViewOnTouchListenerC0367ab(BuddyProfileActivity buddyProfileActivity) {
        this.f1307a = buddyProfileActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1307a.getString(R.string.menu_voice_call));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
