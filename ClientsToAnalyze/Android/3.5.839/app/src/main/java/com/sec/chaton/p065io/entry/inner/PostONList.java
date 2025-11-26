package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONList extends Entry {
    public String endtime;
    public String hasmore;
    public String isblind;

    @EntryField(type = PostONEntry.class)
    public ArrayList<PostONEntry> poston = new ArrayList<>();
    public String totalcount;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONEntry> it = this.poston.iterator();
        while (it.hasNext()) {
            PostONEntry next = it.next();
            sb.append("poston:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
