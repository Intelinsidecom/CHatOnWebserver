package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hn */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0757hn implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3024a;

    ViewOnTouchListenerC0757hn(SpecialBuddyFragment specialBuddyFragment) {
        this.f3024a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3024a.getString(R.string.live_partner_bubble_title_recommend));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
