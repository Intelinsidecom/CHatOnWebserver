package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.p035io.entry.inner.Buddy;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.m */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0798m implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Buddy f3092a;

    /* renamed from: b */
    final /* synthetic */ AddBuddyFragment f3093b;

    ViewOnTouchListenerC0798m(AddBuddyFragment addBuddyFragment, Buddy buddy) {
        this.f3093b = addBuddyFragment;
        this.f3092a = buddy;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f3092a.name);
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
