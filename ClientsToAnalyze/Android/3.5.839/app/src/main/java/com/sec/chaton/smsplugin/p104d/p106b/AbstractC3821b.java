package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.smsplugin.p104d.C3846f;
import java.util.ArrayList;
import org.p146b.p147a.p149b.InterfaceC5243c;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.w3c.dom.NodeList;

/* compiled from: ElementSequentialTimeContainerImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC3821b extends AbstractC3822c implements InterfaceC5243c {
    AbstractC3821b(InterfaceC5247g interfaceC5247g) {
        super(interfaceC5247g);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5245e
    /* renamed from: a */
    public NodeList mo14504a(float f) {
        NodeList nodeListS_ = mo14533s_();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < nodeListS_.getLength()) {
                f -= ((InterfaceC5244d) nodeListS_.item(i2)).mo14506b();
                if (f >= 0.0f) {
                    i = i2 + 1;
                } else {
                    arrayList.add(nodeListS_.item(i2));
                    return new C3846f(arrayList);
                }
            } else {
                return new C3846f(arrayList);
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d, org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public float mo14506b() {
        float fB = super.mo14506b();
        if (fB != 0.0f) {
            return fB;
        }
        NodeList nodeListS_ = mo14533s_();
        int i = 0;
        float fMo14506b = fB;
        while (true) {
            int i2 = i;
            if (i2 < nodeListS_.getLength()) {
                InterfaceC5244d interfaceC5244d = (InterfaceC5244d) nodeListS_.item(i2);
                if (interfaceC5244d.mo14506b() < 0.0f) {
                    return -1.0f;
                }
                fMo14506b += interfaceC5244d.mo14506b();
                i = i2 + 1;
            } else {
                return fMo14506b;
            }
        }
    }
}
