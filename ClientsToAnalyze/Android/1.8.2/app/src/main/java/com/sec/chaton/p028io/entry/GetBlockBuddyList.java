package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.BlockBuddy;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetBlockBuddyList extends Entry {

    @EntryField(type = BlockBuddy.class)
    public ArrayList buddy = new ArrayList();

    @Override // com.sec.chaton.p028io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.buddy.iterator();
        while (it.hasNext()) {
            BlockBuddy blockBuddy = (BlockBuddy) it.next();
            sb.append("Blocked Buddy : ");
            sb.append(blockBuddy.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
