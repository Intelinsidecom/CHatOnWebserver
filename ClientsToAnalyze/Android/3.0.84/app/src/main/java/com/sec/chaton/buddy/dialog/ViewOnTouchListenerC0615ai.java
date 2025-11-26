package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ai */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0615ai implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2833a;

    ViewOnTouchListenerC0615ai(SpecialBuddyDialog specialBuddyDialog) {
        this.f2833a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2833a.getString(R.string.buddy_list_contextual_menu_unfollow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
