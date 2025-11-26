package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.h */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1347h implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4926a;

    ViewOnTouchListenerC1347h(AddBuddyFragment addBuddyFragment) {
        this.f4926a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4926a.getString(R.string.addbuddy_enter_samsung_account));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
