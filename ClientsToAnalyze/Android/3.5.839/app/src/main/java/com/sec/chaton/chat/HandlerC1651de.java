package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.de */
/* loaded from: classes.dex */
class HandlerC1651de extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6183a;

    HandlerC1651de(ChatFragment chatFragment) {
        this.f6183a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 0) {
            if (this.f6183a.f5747ez.m8771a(this.f6183a.f5603bs, this.f6183a.f5487D, this.f6183a.f5488E, this.f6183a.f5560bB)) {
                this.f6183a.m7980aM();
            }
        } else {
            if (message.what == 1) {
                this.f6183a.m7981aN();
                return;
            }
            if (message.what == 2 && this.f6183a.f5731ej != null && this.f6183a.f5731ej.m14354a() && this.f6183a.f5652cp) {
                ChatFragment.m8178l(this.f6183a, 50);
                this.f6183a.m7999aW();
            }
        }
    }
}
