package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.smsplugin.p104d.AbstractC3816b;
import com.sec.chaton.smsplugin.p104d.p105a.C3813a;
import org.p146b.p147a.p148a.InterfaceC5236a;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p149b.InterfaceC5243c;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.p146b.p147a.p149b.InterfaceC5248h;
import org.p146b.p147a.p149b.InterfaceC5257q;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: SmilDocumentImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.e */
/* loaded from: classes.dex */
public class C3824e extends AbstractC3816b implements InterfaceC5236a, InterfaceC5246f {

    /* renamed from: b */
    InterfaceC5243c f13699b;

    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: a */
    public NodeList mo14504a(float f) {
        return this.f13699b.mo14504a(f);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: s_ */
    public NodeList mo14533s_() {
        return this.f13699b.mo14533s_();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public boolean mo14525c() {
        return this.f13699b.mo14525c();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: d */
    public boolean mo14526d() {
        return this.f13699b.mo14526d();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: g */
    public InterfaceC5257q mo14518g() {
        return this.f13699b.mo14518g();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public float mo14506b() {
        return this.f13699b.mo14506b();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: h */
    public InterfaceC5257q mo14519h() {
        return this.f13699b.mo14519h();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: i */
    public short mo14520i() {
        return this.f13699b.mo14520i();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: q_ */
    public void mo14531q_() {
        this.f13699b.mo14531q_();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: r_ */
    public void mo14532r_() {
        this.f13699b.mo14532r_();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public void mo14524c(float f) {
        this.f13699b.mo14524c(f);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public void mo14515b(float f) {
        this.f13699b.mo14515b(f);
    }

    @Override // org.w3c.dom.Document
    public Element createElement(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("text") || lowerCase.equals("img") || lowerCase.equals("video")) {
            return new C3839t(this, lowerCase);
        }
        if (lowerCase.equals("audio")) {
            return new C3828i(this, lowerCase);
        }
        if (lowerCase.equals("layout")) {
            return new C3827h(this, lowerCase);
        }
        if (lowerCase.equals("root-layout")) {
            return new C3840u(this, lowerCase);
        }
        if (lowerCase.equals("region")) {
            return new C3838s(this, lowerCase);
        }
        if (lowerCase.equals("ref")) {
            return new C3837r(this, lowerCase);
        }
        if (lowerCase.equals("par")) {
            return new C3830k(this, lowerCase);
        }
        return new C3826g(this, lowerCase);
    }

    @Override // org.w3c.dom.Document
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public InterfaceC5247g getDocumentElement() {
        Node firstChild = getFirstChild();
        if (firstChild == null || !(firstChild instanceof InterfaceC5247g)) {
            firstChild = createElement("smil");
            appendChild(firstChild);
        }
        return (InterfaceC5247g) firstChild;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5246f
    /* renamed from: k */
    public InterfaceC5247g mo14528k() throws DOMException {
        InterfaceC5247g documentElement = getDocumentElement();
        Node firstChild = documentElement.getFirstChild();
        if (firstChild == null || !(firstChild instanceof InterfaceC5247g)) {
            firstChild = createElement("head");
            documentElement.appendChild(firstChild);
        }
        return (InterfaceC5247g) firstChild;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5246f
    /* renamed from: l */
    public InterfaceC5247g mo14529l() throws DOMException {
        InterfaceC5247g documentElement = getDocumentElement();
        Node nextSibling = mo14528k().getNextSibling();
        if (nextSibling == null || !(nextSibling instanceof InterfaceC5247g)) {
            nextSibling = createElement("body");
            documentElement.appendChild(nextSibling);
        }
        this.f13699b = new C3825f(this, (InterfaceC5247g) nextSibling);
        return (InterfaceC5247g) nextSibling;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5246f
    /* renamed from: m */
    public InterfaceC5248h mo14530m() throws DOMException {
        InterfaceC5247g interfaceC5247gMo14528k = mo14528k();
        Node firstChild = interfaceC5247gMo14528k.getFirstChild();
        while (firstChild != null && !(firstChild instanceof InterfaceC5248h)) {
            firstChild = firstChild.getNextSibling();
        }
        if (firstChild == null) {
            firstChild = new C3827h(this, "layout");
            interfaceC5247gMo14528k.appendChild(firstChild);
        }
        return (InterfaceC5248h) firstChild;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5236a
    /* renamed from: a */
    public InterfaceC5237b mo14523a(String str) {
        if ("Event".equals(str)) {
            return new C3813a();
        }
        throw new DOMException((short) 9, "Not supported interface");
    }
}
