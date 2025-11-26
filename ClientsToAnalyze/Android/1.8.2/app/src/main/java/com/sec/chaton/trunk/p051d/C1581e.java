package com.sec.chaton.trunk.p051d;

import com.sec.chaton.trunk.entry.GetItemEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetItemParser.java */
/* renamed from: com.sec.chaton.trunk.d.e */
/* loaded from: classes.dex */
public class C1581e extends AbstractC1577a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetItemEntry getItemEntry = new GetItemEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        if (elementsByTagName.getLength() == 1) {
            getItemEntry.item = m5449a(elementsByTagName.item(0));
        }
        return getItemEntry;
    }
}
