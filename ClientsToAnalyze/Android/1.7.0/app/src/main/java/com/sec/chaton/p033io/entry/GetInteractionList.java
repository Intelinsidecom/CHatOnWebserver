package com.sec.chaton.p033io.entry;

import com.sec.chaton.p033io.entry.inner.InteractionListEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetInteractionList extends Entry {

    @EntryField(type = InteractionListEntry.class)
    public ArrayList interaction = new ArrayList();

    @Override // com.sec.chaton.p033io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.interaction.iterator();
        while (it.hasNext()) {
            InteractionListEntry interactionListEntry = (InteractionListEntry) it.next();
            sb.append("InteractionList:");
            sb.append(interactionListEntry.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
