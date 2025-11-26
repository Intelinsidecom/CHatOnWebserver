package com.sec.chaton.push.p094c;

import android.content.Context;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.InterfaceC3110b;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.j */
/* loaded from: classes.dex */
class C3089j implements InterfaceC3110b {

    /* renamed from: a */
    final /* synthetic */ AbstractC3072a f11405a;

    /* renamed from: b */
    final /* synthetic */ String f11406b;

    /* renamed from: c */
    final /* synthetic */ C3088i f11407c;

    C3089j(C3088i c3088i, AbstractC3072a abstractC3072a, String str) {
        this.f11407c = c3088i;
        this.f11405a = abstractC3072a;
        this.f11406b = str;
    }

    @Override // com.sec.chaton.push.util.InterfaceC3110b
    /* renamed from: a */
    public void mo12521a(Context context) {
        try {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3088i.f11401a, String.format("Put delayed task to MessageTaskQueue. task: %s", this.f11405a));
            }
            synchronized (C3088i.f11402b) {
                this.f11407c.f11404d.remove(this.f11406b);
            }
            this.f11407c.m12591a(this.f11405a);
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(C3088i.f11401a, e.getMessage(), e);
            }
        }
    }
}
