package com.sec.chaton.userprofile.p047a;

import com.sec.chaton.p033io.entry.GetInteractionList;
import com.sec.chaton.p033io.entry.inner.InteractionEntry;
import com.sec.chaton.p033io.entry.inner.InteractionListEntry;
import com.sec.chaton.trunk.p041a.AbstractC1098b;
import com.sec.chaton.util.C1341p;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: InteractionParser.java */
/* renamed from: com.sec.chaton.userprofile.a.a */
/* loaded from: classes.dex */
public class C1203a extends AbstractC1098b {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        GetInteractionList getInteractionList = new GetInteractionList();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("interaction");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getInteractionList.interaction.add(m4417a(elementsByTagName.item(i)));
        }
        return getInteractionList;
    }

    /* renamed from: a */
    private InteractionListEntry m4417a(Node node) {
        InteractionListEntry interactionListEntry = new InteractionListEntry();
        m4090a(interactionListEntry, node.getAttributes());
        ArrayList arrayList = interactionListEntry.buddyid;
        NodeList childNodes = node.getChildNodes();
        C1341p.m4662e("Interaction Parser week: " + interactionListEntry.week + " totalcount: " + interactionListEntry.totalcount, "InteractionParser");
        for (int i = 0; i < childNodes.getLength(); i++) {
            arrayList.add(m4418b(childNodes.item(i)));
        }
        return interactionListEntry;
    }

    /* renamed from: b */
    private InteractionEntry m4418b(Node node) {
        InteractionEntry interactionEntry = new InteractionEntry();
        m4090a(interactionEntry, node.getAttributes());
        interactionEntry.value = node.getTextContent();
        C1341p.m4662e("Interaction Entry value : " + interactionEntry.value + " Send : " + interactionEntry.send, "Interaction Parser");
        return interactionEntry;
    }
}
