package com.sec.chaton.chat;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0601r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2043a;

    ViewOnTouchListenerC0601r(ChatActivity chatActivity) {
        this.f2043a = chatActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2043a.getString(R.string.dialog_header_text));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
