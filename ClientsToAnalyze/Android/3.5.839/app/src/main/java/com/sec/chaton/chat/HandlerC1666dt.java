package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2300t;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dt */
/* loaded from: classes.dex */
class HandlerC1666dt extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6215a;

    HandlerC1666dt(ChatFragment chatFragment) {
        this.f6215a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 100:
                this.f6215a.m8143f(message.arg1);
                if (this.f6215a.f5753y && this.f6215a.f5487D == EnumC2300t.GROUPCHAT && this.f6215a.f5590bf != null && this.f6215a.f5590bf.size() > 0) {
                    this.f6215a.f5546ao.startInsert(22, null, C2220ah.m10087a(this.f6215a.f5750v, this.f6215a.f5590bf), null);
                    break;
                }
                break;
        }
    }
}
