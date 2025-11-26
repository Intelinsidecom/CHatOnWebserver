package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.k */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0796k implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3090a;

    ViewOnTouchListenerC0796k(AddBuddyFragment addBuddyFragment) {
        this.f3090a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3090a.getString(R.string.results));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
