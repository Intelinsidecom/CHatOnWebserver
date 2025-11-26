package com.sec.chaton.trunk.p041a;

import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: GetTrunkListParser.java */
/* renamed from: com.sec.chaton.trunk.a.c */
/* loaded from: classes.dex */
public class C1099c extends AbstractC1101e {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        GetTrunkListEntry getTrunkListEntry = new GetTrunkListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("trunk");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            Trunk trunk = new Trunk();
            m4090a(trunk, nodeItem.getAttributes());
            getTrunkListEntry.trunks.add(trunk);
        }
        return getTrunkListEntry;
    }
}
