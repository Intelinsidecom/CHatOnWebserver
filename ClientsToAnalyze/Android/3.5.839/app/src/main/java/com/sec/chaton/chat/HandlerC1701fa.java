package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.msgbox.C2680y;
import com.sec.chaton.p057e.EnumC2301u;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fa */
/* loaded from: classes.dex */
class HandlerC1701fa extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6303a;

    HandlerC1701fa(ChatInfoFragment chatInfoFragment) {
        this.f6303a = chatInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && message.obj != null) {
            C2680y c2680y = (C2680y) message.obj;
            this.f6303a.m8328a(this.f6303a.f5776U == EnumC2301u.SMS, c2680y.f9607a.f9606e.booleanValue(), c2680y.f9608b, c2680y.f9609c);
        }
        super.handleMessage(message);
    }
}
