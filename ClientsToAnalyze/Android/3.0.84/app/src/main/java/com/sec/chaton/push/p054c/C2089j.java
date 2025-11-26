package com.sec.chaton.push.p054c;

import android.content.Context;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.InterfaceC2110b;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.j */
/* loaded from: classes.dex */
class C2089j implements InterfaceC2110b {

    /* renamed from: a */
    final /* synthetic */ AbstractC2072a f7995a;

    /* renamed from: b */
    final /* synthetic */ String f7996b;

    /* renamed from: c */
    final /* synthetic */ C2088i f7997c;

    C2089j(C2088i c2088i, AbstractC2072a abstractC2072a, String str) {
        this.f7997c = c2088i;
        this.f7995a = abstractC2072a;
        this.f7996b = str;
    }

    @Override // com.sec.chaton.push.util.InterfaceC2110b
    /* renamed from: a */
    public void mo8178a(Context context) {
        try {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2088i.f7991a, String.format("Put delayed task to MessageTaskQueue. task: %s", this.f7995a));
            }
            synchronized (C2088i.f7992b) {
                this.f7997c.f7994d.remove(this.f7996b);
            }
            this.f7997c.m8248a(this.f7995a);
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(C2088i.f7991a, e.getMessage(), e);
            }
        }
    }
}
