package com.sec.chaton.smsplugin.p104d.p106b;

import java.util.ArrayList;
import org.p146b.p147a.p148a.InterfaceC5236a;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.p146b.p147a.p149b.InterfaceC5257q;
import org.w3c.dom.NodeList;

/* compiled from: SmilParElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.l */
/* loaded from: classes.dex */
class C3831l extends AbstractC3817a {

    /* renamed from: b */
    final /* synthetic */ C3830k f13704b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3831l(C3830k c3830k, InterfaceC5247g interfaceC5247g) {
        super(interfaceC5247g);
        this.f13704b = c3830k;
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d, org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: g */
    public InterfaceC5257q mo14518g() {
        InterfaceC5257q interfaceC5257qG = super.mo14518g();
        if (interfaceC5257qG.mo14613a() > 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(interfaceC5257qG.mo14614a(0));
            return new C3842w(arrayList);
        }
        return interfaceC5257qG;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: s_ */
    public NodeList mo14533s_() {
        return this.f13704b.getChildNodes();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public boolean mo14525c() {
        InterfaceC5237b interfaceC5237bMo14523a = ((InterfaceC5236a) this.f13704b.getOwnerDocument()).mo14523a("Event");
        interfaceC5237bMo14523a.mo14489a("SmilSlideStart", false, false);
        this.f13704b.mo14501a(interfaceC5237bMo14523a);
        return true;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: d */
    public boolean mo14526d() {
        InterfaceC5237b interfaceC5237bMo14523a = ((InterfaceC5236a) this.f13704b.getOwnerDocument()).mo14523a("Event");
        interfaceC5237bMo14523a.mo14489a("SmilSlideEnd", false, false);
        this.f13704b.mo14501a(interfaceC5237bMo14523a);
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
        return ((C3824e) this.f13698a.getOwnerDocument()).f13699b;
    }
}
