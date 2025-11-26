package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.aa */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0607aa implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2822a;

    ViewOnTouchListenerC0607aa(SpecialBuddyDialog specialBuddyDialog) {
        this.f2822a = specialBuddyDialog;
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
