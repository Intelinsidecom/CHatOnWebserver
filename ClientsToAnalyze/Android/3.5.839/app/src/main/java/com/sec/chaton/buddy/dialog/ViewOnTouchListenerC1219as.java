package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.as */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1219as implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4717a;

    ViewOnTouchListenerC1219as(SpecialBuddyDialog specialBuddyDialog) {
        this.f4717a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f4717a.getString(R.string.buddy_list_contextual_menu_unfollow));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
