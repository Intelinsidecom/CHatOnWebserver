package com.sec.chaton.chat;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bm */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0990bm implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4060a;

    ViewOnTouchListenerC0990bm(ChatFragment chatFragment) {
        this.f4060a = chatFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Configuration configuration = this.f4060a.getResources().getConfiguration();
            if (configuration.orientation == 2) {
                if (!GlobalApplication.m6456e()) {
                    this.f4060a.m4851au();
                    this.f4060a.m4798aK();
                }
            } else if (configuration.orientation == 1) {
            }
            this.f4060a.f3633cC = true;
            return false;
        }
        return false;
    }
}
