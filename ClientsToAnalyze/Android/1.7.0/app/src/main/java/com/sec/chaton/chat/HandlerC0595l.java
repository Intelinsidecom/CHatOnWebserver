package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.l */
/* loaded from: classes.dex */
class HandlerC0595l extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2037a;

    HandlerC0595l(ChatActivity chatActivity) {
        this.f2037a = chatActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 900:
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    C1341p.m4660c("[TRUNK] Received METHOD_GET_TRUNK_LIST success", this.f2037a.getClass().getSimpleName());
                    break;
                } else if (c0259g.m928b() == EnumC0518y.ERROR) {
                    C1341p.m4660c("[TRUNK] Received METHOD_GET_TRUNK_LIST fail", this.f2037a.getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
