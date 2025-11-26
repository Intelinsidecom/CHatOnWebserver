package com.sec.chaton.chat;

import android.content.res.Configuration;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ck */
/* loaded from: classes.dex */
class ViewOnClickListenerC1630ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6157a;

    ViewOnClickListenerC1630ck(ChatFragment chatFragment) {
        this.f6157a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.f6157a.getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f6157a.m7973aJ();
            this.f6157a.m8091bf();
        } else if (configuration.orientation == 1) {
        }
        if (!GlobalApplication.m10287f()) {
            this.f6157a.f5635cY = true;
        } else {
            this.f6157a.m8218a();
        }
    }
}
