package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.p033io.entry.inner.Buddy;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bv */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0414bv implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Buddy f1388a;

    /* renamed from: b */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1389b;

    ViewOnTouchListenerC0414bv(AddBuddyActivity.AddBuddyFragment addBuddyFragment, Buddy buddy) {
        this.f1389b = addBuddyFragment;
        this.f1388a = buddy;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f1388a.name);
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
