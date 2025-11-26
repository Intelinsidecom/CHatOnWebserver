package com.sec.chaton.userprofile.p054a;

import com.sec.chaton.p028io.entry.GetInteractionList;
import com.sec.chaton.p028io.entry.inner.InteractionEntry;
import com.sec.chaton.p028io.entry.inner.InteractionListEntry;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import com.sec.chaton.util.C1786r;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: InteractionParser.java */
/* renamed from: com.sec.chaton.userprofile.a.a */
/* loaded from: classes.dex */
public class C1623a extends AbstractC1578b {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        GetInteractionList getInteractionList = new GetInteractionList();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("interaction");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getInteractionList.interaction.add(m5797a(elementsByTagName.item(i)));
        }
        return getInteractionList;
    }

    /* renamed from: a */
    private InteractionListEntry m5797a(Node node) {
        InteractionListEntry interactionListEntry = new InteractionListEntry();
        m5454a(interactionListEntry, node.getAttributes());
        ArrayList arrayList = interactionListEntry.buddyid;
        NodeList childNodes = node.getChildNodes();
        C1786r.m6066e("Interaction Parser week: " + interactionListEntry.week + " totalcount: " + interactionListEntry.totalcount, "InteractionParser");
        for (int i = 0; i < childNodes.getLength(); i++) {
            arrayList.add(m5798b(childNodes.item(i)));
        }
        return interactionListEntry;
    }

    /* renamed from: b */
    private InteractionEntry m5798b(Node node) {
        InteractionEntry interactionEntry = new InteractionEntry();
        m5454a(interactionEntry, node.getAttributes());
        interactionEntry.value = node.getTextContent();
        C1786r.m6066e("Interaction Entry value : " + interactionEntry.value + " Send : " + interactionEntry.send, "Interaction Parser");
        return interactionEntry;
    }
}
