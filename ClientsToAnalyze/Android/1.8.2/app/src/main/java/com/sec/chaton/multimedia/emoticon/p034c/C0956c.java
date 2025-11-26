package com.sec.chaton.multimedia.emoticon.p034c;

import com.sec.chaton.multimedia.emoticon.entry.GetPackageListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetPackageListParser.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.c.c */
/* loaded from: classes.dex */
public class C0956c extends AbstractC0954a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetPackageListEntry getPackageListEntry = new GetPackageListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("package");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getPackageListEntry.packges.add(m3816a(elementsByTagName.item(i)));
        }
        return getPackageListEntry;
    }
}
