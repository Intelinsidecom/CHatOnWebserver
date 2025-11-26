package com.sec.chaton.trunk.p041a;

import com.sec.chaton.trunk.entry.GetItemListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetItemListParser.java */
/* renamed from: com.sec.chaton.trunk.a.f */
/* loaded from: classes.dex */
public class C1102f extends AbstractC1101e {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        GetItemListEntry getItemListEntry = new GetItemListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getItemListEntry.items.add(m4092a(elementsByTagName.item(i)));
        }
        return getItemListEntry;
    }
}
