package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.at */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1220at implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4718a;

    ViewOnTouchListenerC1220at(SpecialBuddyDialog specialBuddyDialog) {
        this.f4718a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4718a.getString(R.string.friend_page_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
