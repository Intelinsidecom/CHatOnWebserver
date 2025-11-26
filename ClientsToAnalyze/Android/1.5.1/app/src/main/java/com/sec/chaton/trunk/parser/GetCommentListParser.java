package com.sec.chaton.trunk.parser;

import com.sec.chaton.trunk.entry.GetCommentListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class GetCommentListParser extends AbstractTrunkXmlParser {
    private static final String NODE_COMMENT = "comment";

    @Override // com.sec.chaton.trunk.parser.AbstractXmlParser
    public Object parse(InputStream inputStream) {
        GetCommentListEntry getCommentListEntry = new GetCommentListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName(NODE_COMMENT);
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getCommentListEntry.comments.add(parsingCommentNode(elementsByTagName.item(i)));
        }
        return getCommentListEntry;
    }
}
