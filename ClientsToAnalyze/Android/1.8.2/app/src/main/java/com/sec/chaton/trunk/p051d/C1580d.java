package com.sec.chaton.trunk.p051d;

import com.sec.chaton.trunk.entry.GetItemListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetItemListParser.java */
/* renamed from: com.sec.chaton.trunk.d.d */
/* loaded from: classes.dex */
public class C1580d extends AbstractC1577a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetItemListEntry getItemListEntry = new GetItemListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getItemListEntry.items.add(m5449a(elementsByTagName.item(i)));
        }
        return getItemListEntry;
    }
}
