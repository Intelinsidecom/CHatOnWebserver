package com.sec.chaton.push.p038b;

import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.InterfaceC0890b;
import com.sec.chaton.push.p039c.InterfaceC0892d;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.b */
/* loaded from: classes.dex */
class C0869b implements InterfaceC0892d {

    /* renamed from: a */
    final /* synthetic */ int f2998a;

    /* renamed from: b */
    final /* synthetic */ C0879l f2999b;

    C0869b(C0879l c0879l, int i) {
        this.f2999b = c0879l;
        this.f2998a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.push.p039c.InterfaceC0892d
    /* renamed from: a */
    public void mo3461a(AbstractC0894f abstractC0894f) {
        if (abstractC0894f != 0 && (abstractC0894f instanceof InterfaceC0890b)) {
            ((InterfaceC0890b) abstractC0894f).mo3486a(this.f2998a, null);
        }
    }
}
