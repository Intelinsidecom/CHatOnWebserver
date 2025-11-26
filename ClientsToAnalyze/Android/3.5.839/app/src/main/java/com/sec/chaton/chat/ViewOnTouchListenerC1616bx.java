package com.sec.chaton.chat;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bx */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1616bx implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6137a;

    ViewOnTouchListenerC1616bx(ChatFragment chatFragment) {
        this.f6137a = chatFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Configuration configuration = this.f6137a.getResources().getConfiguration();
            if (configuration.orientation == 2) {
                this.f6137a.m7973aJ();
                this.f6137a.m8091bf();
            } else if (configuration.orientation == 1) {
            }
            if (!GlobalApplication.m10287f()) {
                this.f6137a.f5635cY = true;
                return false;
            }
            return false;
        }
        return false;
    }
}
