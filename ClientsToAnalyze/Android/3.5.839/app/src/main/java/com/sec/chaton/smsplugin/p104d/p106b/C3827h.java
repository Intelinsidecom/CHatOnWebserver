package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.smsplugin.p109f.C3852b;
import org.p146b.p147a.p149b.InterfaceC5248h;
import org.p146b.p147a.p149b.InterfaceC5255o;
import org.w3c.dom.NodeList;

/* compiled from: SmilLayoutElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.h */
/* loaded from: classes.dex */
public class C3827h extends C3826g implements InterfaceC5248h {
    C3827h(C3824e c3824e, String str) {
        super(c3824e, str);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5248h
    /* renamed from: a */
    public NodeList mo14536a() {
        return getElementsByTagName("region");
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5248h
    /* renamed from: b */
    public InterfaceC5255o mo14537b() {
        NodeList childNodes = getChildNodes();
        int length = childNodes.getLength();
        InterfaceC5255o interfaceC5255o = null;
        for (int i = 0; i < length; i++) {
            if (childNodes.item(i).getNodeName().equals("root-layout")) {
                interfaceC5255o = (InterfaceC5255o) childNodes.item(i);
            }
        }
        if (interfaceC5255o == null) {
            InterfaceC5255o interfaceC5255o2 = (InterfaceC5255o) getOwnerDocument().createElement("root-layout");
            interfaceC5255o2.mo14601d(C3852b.m14736a().m14740b().mo14732a());
            interfaceC5255o2.mo14598c(C3852b.m14736a().m14740b().mo14733b());
            appendChild(interfaceC5255o2);
            return interfaceC5255o2;
        }
        return interfaceC5255o;
    }
}
