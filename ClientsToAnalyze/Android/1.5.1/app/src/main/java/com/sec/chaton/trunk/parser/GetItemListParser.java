package com.sec.chaton.trunk.parser;

import com.sec.chaton.trunk.entry.GetItemListEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class GetItemListParser extends AbstractTrunkXmlParser {
    private static final String NODE_ITEM = "item";

    @Override // com.sec.chaton.trunk.parser.AbstractXmlParser
    public Object parse(InputStream inputStream) {
        GetItemListEntry getItemListEntry = new GetItemListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("item");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getItemListEntry.items.add(parsingTrunkItem(elementsByTagName.item(i)));
        }
        return getItemListEntry;
    }
}
