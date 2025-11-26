package com.sec.chaton.smsplugin.p104d.p106b.p107a;

import com.sec.chaton.smsplugin.p104d.p106b.C3824e;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: SmilContentHandler.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.a.a */
/* loaded from: classes.dex */
public class C3818a extends DefaultHandler {

    /* renamed from: a */
    private InterfaceC5246f f13694a;

    /* renamed from: b */
    private Node f13695b;

    /* renamed from: a */
    public void m14508a() {
        this.f13694a = new C3824e();
        this.f13695b = this.f13694a;
    }

    /* renamed from: b */
    public InterfaceC5246f m14509b() {
        return this.f13694a;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws DOMException {
        Element elementCreateElement = this.f13694a.createElement(str2);
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getLocalName(i) != null && attributes.getValue(i) != null) {
                    elementCreateElement.setAttribute(attributes.getLocalName(i), attributes.getValue(i));
                }
            }
        }
        this.f13695b.appendChild(elementCreateElement);
        this.f13695b = elementCreateElement;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        this.f13695b = this.f13695b.getParentNode();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
    }
}
