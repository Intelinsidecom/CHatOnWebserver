package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.an */
/* loaded from: classes.dex */
class HandlerC2622an extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9471a;

    HandlerC2622an(MsgboxFragment msgboxFragment) {
        this.f9471a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 5) {
            C2654bs.m11169a().m11187a(3, this.f9471a.f9355ai);
        }
        super.handleMessage(message);
    }
}
