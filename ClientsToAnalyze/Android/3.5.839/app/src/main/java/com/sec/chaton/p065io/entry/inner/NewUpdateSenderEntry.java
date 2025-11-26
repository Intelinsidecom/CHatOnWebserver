package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class NewUpdateSenderEntry extends Entry implements Serializable {

    @EntryField(type = NewUpdateBuddyEntry.class)
    public ArrayList<NewUpdateBuddyEntry> buddy = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<NewUpdateBuddyEntry> it = this.buddy.iterator();
        int i = 1;
        while (it.hasNext()) {
            NewUpdateBuddyEntry next = it.next();
            sb.append("buddy");
            sb.append(i);
            sb.append(":");
            sb.append(next.toString());
            i++;
        }
        return sb.toString();
    }
}
