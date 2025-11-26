package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.fd */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0400fd implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1559a;

    ViewOnTouchListenerC0400fd(SpecialBuddyActivity specialBuddyActivity) {
        this.f1559a = specialBuddyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1559a.getString(R.string.buddy_profile_button_addbuddy));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
