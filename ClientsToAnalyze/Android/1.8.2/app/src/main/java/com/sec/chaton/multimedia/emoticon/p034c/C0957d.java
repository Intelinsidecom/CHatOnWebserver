package com.sec.chaton.multimedia.emoticon.p034c;

import com.sec.chaton.multimedia.emoticon.entry.InstallPackageEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: InstallPackageParser.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.c.d */
/* loaded from: classes.dex */
public class C0957d extends AbstractC0954a {

    /* renamed from: n */
    protected final String f3530n = "packagezipurl";

    /* renamed from: o */
    protected final String f3531o = "cdproxyurl";

    /* renamed from: p */
    protected final String f3532p = "expirationtime";

    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        InstallPackageEntry installPackageEntry = new InstallPackageEntry();
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        documentElement.normalize();
        Node nodeItem = documentElement.getElementsByTagName("package").item(0);
        m5454a(installPackageEntry, nodeItem.getAttributes());
        installPackageEntry.packagezipurl = m5452a(nodeItem, "packagezipurl");
        installPackageEntry.cdproxyurl = m5452a(nodeItem, "cdproxyurl");
        installPackageEntry.expirationtime = Long.parseLong(m5452a(nodeItem, "expirationtime"));
        NodeList elementsByTagName = documentElement.getElementsByTagName("anicon");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            installPackageEntry.emoticons.add(m3817b(elementsByTagName.item(i)));
        }
        return installPackageEntry;
    }
}
