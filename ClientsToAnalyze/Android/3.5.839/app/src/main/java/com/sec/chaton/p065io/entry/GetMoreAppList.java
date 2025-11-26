package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.MoreAppList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetMoreAppList extends Entry {
    public String count;

    @EntryField(type = MoreAppList.class)
    public ArrayList<MoreAppList> plus = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<MoreAppList> it = this.plus.iterator();
        while (it.hasNext()) {
            MoreAppList next = it.next();
            sb.append("MoreAppList:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
