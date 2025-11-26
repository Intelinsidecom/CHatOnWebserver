package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bp */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0408bp implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1382a;

    ViewOnTouchListenerC0408bp(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1382a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1382a.getString(R.string.layout_regist_select_country_code_if_differs));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
