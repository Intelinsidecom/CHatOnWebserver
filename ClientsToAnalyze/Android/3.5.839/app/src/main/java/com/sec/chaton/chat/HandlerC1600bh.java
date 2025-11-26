package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bh */
/* loaded from: classes.dex */
class HandlerC1600bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6106a;

    HandlerC1600bh(ChatFragment chatFragment) {
        this.f6106a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0788l c0788l = (C0788l) message.obj;
        if (c0788l == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("resultEntry is null", ChatFragment.f5461a);
            }
        } else {
            if (c0788l.f2172a || C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.REGARD_SUCCEESS) {
                ((InterfaceC1668dv) this.f6106a.getActivity()).mo7821f();
            }
            if (c0788l.m3152g() == 7005) {
                this.f6106a.m8242b();
            }
            super.handleMessage(message);
        }
    }
}
