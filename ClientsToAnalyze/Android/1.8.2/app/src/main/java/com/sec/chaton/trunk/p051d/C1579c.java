package com.sec.chaton.trunk.p051d;

import com.sec.chaton.trunk.entry.GetCommentListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetCommentListParser.java */
/* renamed from: com.sec.chaton.trunk.d.c */
/* loaded from: classes.dex */
public class C1579c extends AbstractC1577a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetCommentListEntry getCommentListEntry = new GetCommentListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("comment");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getCommentListEntry.comments.add(m5451c(elementsByTagName.item(i)));
        }
        return getCommentListEntry;
    }
}
