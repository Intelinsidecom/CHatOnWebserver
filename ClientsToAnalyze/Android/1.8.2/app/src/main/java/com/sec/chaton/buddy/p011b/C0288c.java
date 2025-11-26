package com.sec.chaton.buddy.p011b;

import com.sec.chaton.p028io.entry.UnBlock;
import com.sec.chaton.p028io.entry.UnBlockBuddyList;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: UnBlockBuddyListParser.java */
/* renamed from: com.sec.chaton.buddy.b.c */
/* loaded from: classes.dex */
public class C0288c extends AbstractC1578b {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        UnBlockBuddyList unBlockBuddyList = new UnBlockBuddyList();
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        documentElement.getElementsByTagName("return");
        NodeList elementsByTagName = documentElement.getElementsByTagName("return");
        if (elementsByTagName.getLength() == 0) {
            elementsByTagName = documentElement.getElementsByTagName("buddy");
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            UnBlock unBlock = new UnBlock();
            m5454a(unBlock, nodeItem.getAttributes());
            unBlock.buddyid = nodeItem.getFirstChild().getNodeValue();
            unBlockBuddyList.buddies.add(unBlock);
        }
        return unBlockBuddyList;
    }
}
