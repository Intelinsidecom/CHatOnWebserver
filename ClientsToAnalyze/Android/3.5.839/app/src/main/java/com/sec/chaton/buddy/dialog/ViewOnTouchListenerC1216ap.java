package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ap */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1216ap implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4714a;

    ViewOnTouchListenerC1216ap(SpecialBuddyDialog specialBuddyDialog) {
        this.f4714a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4714a.getString(R.string.buddy_list_contextual_menu_follow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
