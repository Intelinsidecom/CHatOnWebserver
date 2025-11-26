package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1293f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4829a;

    ViewOnTouchListenerC1293f(AddBuddyFragment addBuddyFragment) {
        this.f4829a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4829a.getString(R.string.layout_regist_select_country_code_if_differs));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
