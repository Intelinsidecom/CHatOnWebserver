package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.BlockBuddy;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetBlockBuddyList extends Entry {

    @EntryField(type = BlockBuddy.class)
    public ArrayList<BlockBuddy> buddy = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<BlockBuddy> it = this.buddy.iterator();
        while (it.hasNext()) {
            BlockBuddy next = it.next();
            sb.append("Blocked Buddy : ");
            sb.append(next.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
