package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.aj */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0616aj implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2834a;

    ViewOnTouchListenerC0616aj(SpecialBuddyDialog specialBuddyDialog) {
        this.f2834a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2834a.getString(R.string.buddy_page_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
