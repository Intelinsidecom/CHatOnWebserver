package com.sec.chaton.chat;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.s */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0602s implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2044a;

    ViewOnTouchListenerC0602s(ChatActivity chatActivity) {
        this.f2044a = chatActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(this.f2044a.getString(R.string.trunk_title));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
