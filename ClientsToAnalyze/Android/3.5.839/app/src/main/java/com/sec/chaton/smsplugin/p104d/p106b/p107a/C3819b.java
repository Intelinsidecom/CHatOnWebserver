package com.sec.chaton.smsplugin.p104d.p106b.p107a;

import com.sec.google.android.p134a.C5111c;
import java.io.IOException;
import java.io.InputStream;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* compiled from: SmilXmlParser.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.a.b */
/* loaded from: classes.dex */
public class C3819b {

    /* renamed from: a */
    private XMLReader f13696a;

    /* renamed from: b */
    private C3818a f13697b;

    public C3819b() throws C5111c {
        System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
        try {
            this.f13696a = XMLReaderFactory.createXMLReader();
            this.f13697b = new C3818a();
            this.f13696a.setContentHandler(this.f13697b);
        } catch (SAXException e) {
            throw new C5111c(e);
        }
    }

    /* renamed from: a */
    public InterfaceC5246f m14511a(InputStream inputStream) throws SAXException, IOException {
        this.f13697b.m14508a();
        this.f13696a.parse(new InputSource(inputStream));
        InterfaceC5246f interfaceC5246fM14509b = this.f13697b.m14509b();
        m14510a(interfaceC5246fM14509b);
        return interfaceC5246fM14509b;
    }

    /* renamed from: a */
    private void m14510a(InterfaceC5246f interfaceC5246f) {
        interfaceC5246f.mo14529l();
        interfaceC5246f.mo14530m();
    }
}
