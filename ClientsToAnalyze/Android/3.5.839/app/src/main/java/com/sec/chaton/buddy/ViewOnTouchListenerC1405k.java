package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.p065io.entry.inner.Buddy;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.k */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1405k implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Buddy f5038a;

    /* renamed from: b */
    final /* synthetic */ AddBuddyFragment f5039b;

    ViewOnTouchListenerC1405k(AddBuddyFragment addBuddyFragment, Buddy buddy) {
        this.f5039b = addBuddyFragment;
        this.f5038a = buddy;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f5038a.name);
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
