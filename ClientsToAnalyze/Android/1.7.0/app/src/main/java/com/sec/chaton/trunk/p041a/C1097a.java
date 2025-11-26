package com.sec.chaton.trunk.p041a;

import com.sec.chaton.trunk.entry.GetCommentListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: GetCommentListParser.java */
/* renamed from: com.sec.chaton.trunk.a.a */
/* loaded from: classes.dex */
public class C1097a extends AbstractC1101e {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        GetCommentListEntry getCommentListEntry = new GetCommentListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("comment");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getCommentListEntry.comments.add(m4094c(elementsByTagName.item(i)));
        }
        return getCommentListEntry;
    }
}
