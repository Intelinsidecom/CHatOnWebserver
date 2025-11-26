package com.sec.chaton.buddy.p011b;

import com.sec.chaton.p028io.entry.GetSpecialBuddyList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: GetSpecialBuddyListParser.java */
/* renamed from: com.sec.chaton.buddy.b.b */
/* loaded from: classes.dex */
public class C0287b extends AbstractC0286a {
    @Override // com.sec.chaton.buddy.p011b.AbstractC0286a, com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetSpecialBuddyList getSpecialBuddyList = new GetSpecialBuddyList();
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        documentElement.getElementsByTagName("specialuser");
        NodeList elementsByTagName = documentElement.getElementsByTagName("specialuser");
        if (elementsByTagName.getLength() == 0) {
            elementsByTagName = documentElement.getElementsByTagName("specialbuddy");
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getSpecialBuddyList.specialuser.add(m2368a(elementsByTagName.item(i)));
        }
        return getSpecialBuddyList;
    }
}
