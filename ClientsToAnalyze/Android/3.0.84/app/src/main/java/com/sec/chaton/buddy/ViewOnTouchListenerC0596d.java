package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.d */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0596d implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2577a;

    ViewOnTouchListenerC0596d(AddBuddyFragment addBuddyFragment) {
        this.f2577a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2577a.getString(R.string.layout_regist_select_country_code_if_differs));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
