package com.sec.chaton.push.p044c;

import android.content.Context;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.InterfaceC1134b;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.j */
/* loaded from: classes.dex */
class C1116j implements InterfaceC1134b {

    /* renamed from: a */
    final /* synthetic */ AbstractC1099a f4091a;

    /* renamed from: b */
    final /* synthetic */ String f4092b;

    /* renamed from: c */
    final /* synthetic */ C1115i f4093c;

    C1116j(C1115i c1115i, AbstractC1099a abstractC1099a, String str) {
        this.f4093c = c1115i;
        this.f4091a = abstractC1099a;
        this.f4092b = str;
    }

    @Override // com.sec.chaton.push.util.InterfaceC1134b
    /* renamed from: a */
    public void mo4134a(Context context) {
        try {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1115i.f4087a, String.format("Put delayed task to MessageTaskQueue. task: %s", this.f4091a));
            }
            synchronized (C1115i.f4088b) {
                this.f4093c.f4090d.remove(this.f4092b);
            }
            this.f4093c.m4203a(this.f4091a);
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(C1115i.f4087a, e.getMessage(), e);
            }
        }
    }
}
