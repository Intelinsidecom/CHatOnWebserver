package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hv */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1369hv implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4969a;

    ViewOnTouchListenerC1369hv(SpecialBuddyFragment specialBuddyFragment) {
        this.f4969a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4969a.getString(R.string.live_partner_bubble_title_recommend));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
