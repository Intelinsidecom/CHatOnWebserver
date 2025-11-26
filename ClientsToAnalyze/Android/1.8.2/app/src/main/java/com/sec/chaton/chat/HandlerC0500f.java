package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.f */
/* loaded from: classes.dex */
class HandlerC0500f extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2096a;

    HandlerC0500f(ChatFragment chatFragment) {
        this.f2096a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 900:
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    C1786r.m6063c("[TRUNK] Received METHOD_GET_TRUNK_LIST success", this.f2096a.getClass().getSimpleName());
                    break;
                } else if (c0101b.m665b() == EnumC0803m.ERROR) {
                    C1786r.m6063c("[TRUNK] Received METHOD_GET_TRUNK_LIST fail", this.f2096a.getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
