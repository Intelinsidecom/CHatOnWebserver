package com.sec.chaton.trunk.parser;

import com.sec.chaton.trunk.entry.GetItemEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class GetItemParser extends AbstractTrunkXmlParser {
    private static final String NODE_ITEM = "item";

    @Override // com.sec.chaton.trunk.parser.AbstractXmlParser
    public Object parse(InputStream inputStream) {
        GetItemEntry getItemEntry = new GetItemEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        if (elementsByTagName.getLength() == 1) {
            getItemEntry.item = parsingTrunkItem(elementsByTagName.item(0));
        }
        return getItemEntry;
    }
}
