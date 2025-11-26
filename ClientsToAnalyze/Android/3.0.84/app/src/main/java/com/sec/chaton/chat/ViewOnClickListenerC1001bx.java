package com.sec.chaton.chat;

import android.content.res.Configuration;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bx */
/* loaded from: classes.dex */
class ViewOnClickListenerC1001bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4075a;

    ViewOnClickListenerC1001bx(ChatFragment chatFragment) {
        this.f4075a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.f4075a.getResources().getConfiguration();
        if (configuration.orientation == 2) {
            if (!GlobalApplication.m6456e()) {
                this.f4075a.m4851au();
                this.f4075a.m4798aK();
            }
        } else if (configuration.orientation == 1) {
        }
        this.f4075a.f3633cC = true;
    }
}
