package com.sec.chaton.trunk.p051d;

import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: GetTrunkListParser.java */
/* renamed from: com.sec.chaton.trunk.d.f */
/* loaded from: classes.dex */
public class C1582f extends AbstractC1577a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetTrunkListEntry getTrunkListEntry = new GetTrunkListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("trunk");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            Trunk trunk = new Trunk();
            m5454a(trunk, nodeItem.getAttributes());
            getTrunkListEntry.trunks.add(trunk);
        }
        return getTrunkListEntry;
    }
}
