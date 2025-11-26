package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p149b.InterfaceC5242b;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.p146b.p147a.p149b.InterfaceC5256p;
import org.p146b.p147a.p149b.InterfaceC5257q;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;

/* compiled from: ElementParallelTimeContainerImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC3817a extends AbstractC3822c implements InterfaceC5242b {
    AbstractC3817a(InterfaceC5247g interfaceC5247g) {
        super(interfaceC5247g);
    }

    /* renamed from: a */
    public String m14503a() {
        String attribute = this.f13698a.getAttribute("endsync");
        if (attribute == null || attribute.length() == 0) {
            m14505a("last");
            return "last";
        }
        if (!"first".equals(attribute) && !"last".equals(attribute) && !"all".equals(attribute) && !"media".equals(attribute)) {
            m14505a("last");
            return "last";
        }
        return attribute;
    }

    /* renamed from: a */
    public void m14505a(String str) {
        if ("first".equals(str) || "last".equals(str) || "all".equals(str) || "media".equals(str)) {
            this.f13698a.setAttribute("endsync", str);
            return;
        }
        throw new DOMException((short) 9, "Unsupported endsync value" + str);
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d, org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public float mo14506b() {
        float fB = super.mo14506b();
        if (fB == 0.0f) {
            return m14507o_();
        }
        return fB;
    }

    /* renamed from: o_ */
    public float m14507o_() {
        float f;
        if ("last".equals(m14503a())) {
            NodeList nodeListS_ = mo14533s_();
            f = -1.0f;
            for (int i = 0; i < nodeListS_.getLength(); i++) {
                InterfaceC5257q interfaceC5257qMo14519h = ((InterfaceC5244d) nodeListS_.item(i)).mo14519h();
                for (int i2 = 0; i2 < interfaceC5257qMo14519h.mo14613a(); i2++) {
                    InterfaceC5256p interfaceC5256pMo14614a = interfaceC5257qMo14519h.mo14614a(i2);
                    if (interfaceC5256pMo14614a.mo14612d() == 0) {
                        return -1.0f;
                    }
                    if (interfaceC5256pMo14614a.mo14610b()) {
                        float fMo14611c = (float) interfaceC5256pMo14614a.mo14611c();
                        if (fMo14611c > f) {
                            f = fMo14611c;
                        }
                    }
                }
            }
        } else {
            f = -1.0f;
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.w3c.dom.NodeList mo14504a(float r17) {
        /*
            r16 = this;
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            org.w3c.dom.NodeList r10 = r16.mo14533s_()
            int r11 = r10.getLength()
            r1 = 0
            r8 = r1
        Lf:
            if (r8 >= r11) goto L88
            r5 = 0
            r3 = 0
            org.w3c.dom.Node r1 = r10.item(r8)
            org.b.a.b.d r1 = (org.p146b.p147a.p149b.InterfaceC5244d) r1
            org.b.a.b.q r12 = r1.mo14518g()
            int r13 = r12.mo14613a()
            r2 = 0
            r7 = r2
            r2 = r3
        L25:
            if (r7 >= r13) goto L4c
            org.b.a.b.p r3 = r12.mo14614a(r7)
            boolean r4 = r3.mo14610b()
            if (r4 == 0) goto L90
            double r3 = r3.mo14611c()
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 * r14
            r0 = r17
            double r14 = (double) r0
            int r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r14 > 0) goto L90
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 < 0) goto L90
            r2 = 1
        L47:
            int r5 = r7 + 1
            r7 = r5
            r5 = r3
            goto L25
        L4c:
            org.b.a.b.q r12 = r1.mo14519h()
            int r13 = r12.mo14613a()
            r3 = 0
            r7 = r3
        L56:
            if (r7 >= r13) goto L7d
            org.b.a.b.p r3 = r12.mo14614a(r7)
            boolean r4 = r3.mo14610b()
            if (r4 == 0) goto L8e
            double r3 = r3.mo14611c()
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 * r14
            r0 = r17
            double r14 = (double) r0
            int r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r14 > 0) goto L8e
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 < 0) goto L8e
            r2 = 0
        L78:
            int r5 = r7 + 1
            r7 = r5
            r5 = r3
            goto L56
        L7d:
            if (r2 == 0) goto L84
            org.w3c.dom.Node r1 = (org.w3c.dom.Node) r1
            r9.add(r1)
        L84:
            int r1 = r8 + 1
            r8 = r1
            goto Lf
        L88:
            com.sec.chaton.smsplugin.d.f r1 = new com.sec.chaton.smsplugin.d.f
            r1.<init>(r9)
            return r1
        L8e:
            r3 = r5
            goto L78
        L90:
            r3 = r5
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p104d.p106b.AbstractC3817a.mo14504a(float):org.w3c.dom.NodeList");
    }
}
