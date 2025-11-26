package com.sec.chaton.trunk.parser;

import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class GetTrunkListParser extends AbstractTrunkXmlParser {
    private static final String NODE_TRUNK = "trunk";

    @Override // com.sec.chaton.trunk.parser.AbstractXmlParser
    public Object parse(InputStream inputStream) {
        GetTrunkListEntry getTrunkListEntry = new GetTrunkListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("trunk");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            Trunk trunk = new Trunk();
            setAttributeToObject(trunk, nodeItem.getAttributes());
            getTrunkListEntry.trunks.add(trunk);
        }
        return getTrunkListEntry;
    }
}
