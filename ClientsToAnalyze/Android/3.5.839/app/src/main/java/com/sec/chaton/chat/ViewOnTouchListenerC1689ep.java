package com.sec.chaton.chat;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatInfoAdapter.java */
/* renamed from: com.sec.chaton.chat.ep */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1689ep implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C1688eo f6277a;

    ViewOnTouchListenerC1689ep(C1688eo c1688eo) {
        this.f6277a = c1688eo;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setContentDescription(GlobalApplication.m10283b().getString(R.string.buddy_add_contact));
            view.sendAccessibilityEvent(8);
            return false;
        }
        return false;
    }
}
