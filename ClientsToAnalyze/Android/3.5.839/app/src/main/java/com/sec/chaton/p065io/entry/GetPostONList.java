package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.PostONList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetPostONList extends Entry {

    @EntryField(type = PostONList.class)
    public ArrayList<PostONList> postonlist = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONList> it = this.postonlist.iterator();
        while (it.hasNext()) {
            PostONList next = it.next();
            sb.append("PostONList:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
