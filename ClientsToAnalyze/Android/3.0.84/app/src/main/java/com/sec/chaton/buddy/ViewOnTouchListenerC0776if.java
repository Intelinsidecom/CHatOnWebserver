package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.if */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0776if implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3047a;

    ViewOnTouchListenerC0776if(SpecialBuddyFragment specialBuddyFragment) {
        this.f3047a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3047a.getString(R.string.buddy_list_contextual_menu_follow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
