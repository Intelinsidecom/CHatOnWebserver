package com.sec.chaton.buddy.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ag */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0613ag implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2831a;

    ViewOnTouchListenerC0613ag(SpecialBuddyDialog specialBuddyDialog) {
        this.f2831a = specialBuddyDialog;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2831a.getString(R.string.menu_button_start_chat));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
