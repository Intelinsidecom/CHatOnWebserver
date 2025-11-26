package com.sec.chaton.p028io.p029a;

import com.sec.chaton.p028io.entry.GetContentCategoryList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: GetContentCategoryListParser.java */
/* renamed from: com.sec.chaton.io.a.b */
/* loaded from: classes.dex */
public class C0831b extends AbstractC0830a {
    @Override // com.sec.chaton.p028io.p029a.AbstractC0830a, com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetContentCategoryList getContentCategoryList = new GetContentCategoryList();
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        NodeList elementsByTagName = documentElement.getElementsByTagName("contentcategory");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getContentCategoryList.contentcategory.add(m3479a(elementsByTagName.item(i)));
        }
        getContentCategoryList.likecount = documentElement.getElementsByTagName("likecount").item(0).getTextContent();
        getContentCategoryList.followcount = documentElement.getElementsByTagName("followcount").item(0).getTextContent();
        return getContentCategoryList;
    }
}
