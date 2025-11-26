package com.sec.chaton.msgbox;

import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.h */
/* loaded from: classes.dex */
class RunnableC2663h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HandlerC2661f f9562a;

    RunnableC2663h(HandlerC2661f handlerC2661f) {
        this.f9562a = handlerC2661f;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9562a.f9560h.m11212a(this.f9562a.f9553a, this.f9562a.f9554b, this.f9562a.f9555c, this.f9562a.f9556d, this.f9562a.f9557e, false, (ArrayList<String>) this.f9562a.f9558f);
    }
}
