package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ih */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1382ih implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4985a;

    ViewOnTouchListenerC1382ih(SpecialBuddyFragment specialBuddyFragment) {
        this.f4985a = specialBuddyFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
