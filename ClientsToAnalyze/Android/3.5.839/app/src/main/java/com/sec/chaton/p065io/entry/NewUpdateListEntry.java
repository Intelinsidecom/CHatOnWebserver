package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.NewUpdateEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class NewUpdateListEntry extends Entry {
    public String hasmore;

    @EntryField(type = NewUpdateEntry.class)
    public ArrayList<NewUpdateEntry> newupdate = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<NewUpdateEntry> it = this.newupdate.iterator();
        while (it.hasNext()) {
            NewUpdateEntry next = it.next();
            sb.append("newupdate:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
