package com.sec.chaton.p028io.p029a;

import com.sec.chaton.p028io.entry.NotificationEntry;
import com.sec.chaton.p028io.entry.inner.Badge;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NotificationTaskParser.java */
/* renamed from: com.sec.chaton.io.a.c */
/* loaded from: classes.dex */
public class C0832c extends AbstractC1578b {

    /* renamed from: a */
    protected final String f3045a = "badge";

    /* renamed from: b */
    protected final String f3046b = "content";

    /* renamed from: c */
    protected final String f3047c = "trunklist";

    /* renamed from: d */
    protected final String f3048d = "trunk";

    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        NotificationEntry notificationEntry = new NotificationEntry();
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        documentElement.normalize();
        m5454a(notificationEntry, documentElement.getAttributes());
        NodeList childNodes = documentElement.getElementsByTagName("badge").item(0).getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeName().equals("content")) {
                Badge badge = new Badge();
                m5454a(badge, nodeItem.getAttributes());
                notificationEntry.badges.add(badge);
            }
        }
        NodeList childNodes2 = documentElement.getElementsByTagName("trunklist").item(0).getChildNodes();
        for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
            Node nodeItem2 = childNodes2.item(i2);
            Trunk trunk = new Trunk();
            m5454a(trunk, nodeItem2.getAttributes());
            notificationEntry.trunks.add(trunk);
        }
        return notificationEntry;
    }
}
