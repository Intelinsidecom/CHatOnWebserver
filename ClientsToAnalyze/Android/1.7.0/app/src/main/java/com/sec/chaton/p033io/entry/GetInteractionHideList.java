package com.sec.chaton.p033io.entry;

import com.sec.chaton.p033io.entry.inner.InteractionHideEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetInteractionHideList extends Entry {

    @EntryField(type = InteractionHideEntry.class)
    public ArrayList buddyid = new ArrayList();
    public String totalcount;

    @Override // com.sec.chaton.p033io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.buddyid.iterator();
        while (it.hasNext()) {
            InteractionHideEntry interactionHideEntry = (InteractionHideEntry) it.next();
            sb.append("InteractionHideList:");
            sb.append(interactionHideEntry.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
