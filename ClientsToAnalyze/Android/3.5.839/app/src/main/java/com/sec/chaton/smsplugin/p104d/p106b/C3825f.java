package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.w3c.dom.NodeList;

/* compiled from: SmilDocumentImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.f */
/* loaded from: classes.dex */
class C3825f extends AbstractC3821b {

    /* renamed from: b */
    final /* synthetic */ C3824e f13700b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3825f(C3824e c3824e, InterfaceC5247g interfaceC5247g) {
        super(interfaceC5247g);
        this.f13700b = c3824e;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: s_ */
    public NodeList mo14533s_() {
        return this.f13700b.mo14529l().getElementsByTagName("par");
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public boolean mo14525c() {
        InterfaceC5237b interfaceC5237bMo14523a = this.f13700b.mo14523a("Event");
        interfaceC5237bMo14523a.mo14489a("SmilDocumentStart", false, false);
        this.f13700b.mo14501a(interfaceC5237bMo14523a);
        return true;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: d */
    public boolean mo14526d() {
        InterfaceC5237b interfaceC5237bMo14523a = this.f13700b.mo14523a("Event");
        interfaceC5237bMo14523a.mo14489a("SimlDocumentEnd", false, false);
        this.f13700b.mo14501a(interfaceC5237bMo14523a);
        return true;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: q_ */
    public void mo14531q_() {
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: r_ */
    public void mo14532r_() {
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public void mo14524c(float f) {
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d
    /* renamed from: f */
    InterfaceC5244d mo14517f() {
        return null;
    }
}
