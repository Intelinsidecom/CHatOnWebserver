package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5252l;
import org.p146b.p147a.p149b.InterfaceC5254n;
import org.w3c.dom.NodeList;

/* compiled from: SmilRegionMediaElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.t */
/* loaded from: classes.dex */
public class C3839t extends C3828i implements InterfaceC5254n {

    /* renamed from: c */
    private InterfaceC5252l f13733c;

    C3839t(C3824e c3824e, String str) {
        super(c3824e, str);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5253m
    /* renamed from: k */
    public InterfaceC5252l mo14605k() {
        if (this.f13733c == null) {
            NodeList elementsByTagName = ((InterfaceC5246f) getOwnerDocument()).mo14530m().getElementsByTagName("region");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elementsByTagName.getLength()) {
                    break;
                }
                InterfaceC5252l interfaceC5252l = (InterfaceC5252l) elementsByTagName.item(i2);
                if (interfaceC5252l.mo14535j().equals(getAttribute("region"))) {
                    this.f13733c = interfaceC5252l;
                }
                i = i2 + 1;
            }
        }
        return this.f13733c;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5253m
    /* renamed from: a */
    public void mo14604a(InterfaceC5252l interfaceC5252l) {
        setAttribute("region", interfaceC5252l.mo14535j());
        this.f13733c = interfaceC5252l;
    }
}
