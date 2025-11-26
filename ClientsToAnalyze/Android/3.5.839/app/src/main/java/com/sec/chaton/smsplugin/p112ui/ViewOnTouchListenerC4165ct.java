package com.sec.chaton.smsplugin.p112ui;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: MessagingInfoAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ct */
/* loaded from: classes.dex */
class ViewOnTouchListenerC4165ct implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C4164cs f15471a;

    ViewOnTouchListenerC4165ct(C4164cs c4164cs) {
        this.f15471a = c4164cs;
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
