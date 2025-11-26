package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.MoreAppList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetMoreAppList extends Entry {
    public String count;

    @EntryField(type = MoreAppList.class)
    public ArrayList<MoreAppList> more = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<MoreAppList> it = this.more.iterator();
        while (it.hasNext()) {
            MoreAppList next = it.next();
            sb.append("MoreAppList:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
