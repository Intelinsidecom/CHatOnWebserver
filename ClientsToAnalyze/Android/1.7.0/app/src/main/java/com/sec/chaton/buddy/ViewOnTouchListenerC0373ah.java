package com.sec.chaton.buddy;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ah */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0373ah implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1341a;

    ViewOnTouchListenerC0373ah(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1341a = buddyGroupProfileActivity;
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
