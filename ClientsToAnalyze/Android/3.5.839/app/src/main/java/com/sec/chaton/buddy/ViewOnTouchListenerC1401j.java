package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.j */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1401j implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5032a;

    ViewOnTouchListenerC1401j(AddBuddyFragment addBuddyFragment) {
        this.f5032a = addBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f5032a.getString(R.string.results));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
