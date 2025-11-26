package com.sec.chaton.trunk.p041a;

import com.sec.chaton.trunk.entry.GetItemEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetItemParser.java */
/* renamed from: com.sec.chaton.trunk.a.d */
/* loaded from: classes.dex */
public class C1100d extends AbstractC1101e {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        GetItemEntry getItemEntry = new GetItemEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        if (elementsByTagName.getLength() == 1) {
            getItemEntry.item = m4092a(elementsByTagName.item(0));
        }
        return getItemEntry;
    }
}
