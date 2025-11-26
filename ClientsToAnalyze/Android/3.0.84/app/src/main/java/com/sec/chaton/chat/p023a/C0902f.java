package com.sec.chaton.chat.p023a;

import com.sec.chaton.chat.InterfaceC1093fh;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;
import org.p072a.p073a.p074a.AbstractC3707b;

/* compiled from: BubbleDrawerFactory.java */
/* renamed from: com.sec.chaton.chat.a.f */
/* loaded from: classes.dex */
public class C0902f extends AbstractC3707b<EnumC1455w, AbstractC0888a> {
    @Override // org.p072a.p073a.p074a.InterfaceC3710e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC0888a mo5109a(EnumC1455w enumC1455w) {
        switch (C0903g.f3839a[enumC1455w.ordinal()]) {
            case 1:
                return new C0922z();
            case 2:
                return new C0893ae();
            case 3:
            case 4:
                return new C0916t();
            case 5:
                return new C0898b();
            case 6:
                return new C0914r();
            case 7:
                return new C0904h();
            case 8:
                return new C0900d();
            case 9:
                return new C0897ai();
            case 10:
                return new C0905i();
            case 11:
            case 12:
                return new C0913q();
            case 13:
                return new C0899c();
            case 14:
                return new C0919w();
            case 15:
                return new C0918v();
            case 16:
            default:
                return null;
            case 17:
                return new C0896ah();
        }
    }

    @Override // org.p072a.p073a.p074a.AbstractC3707b, org.p072a.p073a.p074a.InterfaceC3710e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo5111a(EnumC1455w enumC1455w, AbstractC0888a abstractC0888a) {
        super.mo5111a((C0902f) enumC1455w, (EnumC1455w) abstractC0888a);
        C3250y.m11450b("PASSIVE OBJECT: " + abstractC0888a, C0902f.class.getSimpleName());
        abstractC0888a.m5089a((InterfaceC1093fh) null);
        abstractC0888a.mo5090a(false);
    }
}
