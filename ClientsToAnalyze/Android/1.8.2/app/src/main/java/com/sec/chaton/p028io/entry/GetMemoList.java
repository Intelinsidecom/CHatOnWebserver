package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.MemoEntry;
import com.sec.chaton.p028io.entry.inner.MemoListEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetMemoList extends Entry {

    @EntryField(type = MemoListEntry.class)
    public ArrayList memolist = new ArrayList();

    @EntryField(type = MemoEntry.class)
    public ArrayList memo = new ArrayList();

    @Override // com.sec.chaton.p028io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.memolist.iterator();
        while (it.hasNext()) {
            MemoListEntry memoListEntry = (MemoListEntry) it.next();
            sb.append("MemoList:");
            sb.append(memoListEntry.toString());
        }
        sb.append("\n");
        Iterator it2 = this.memo.iterator();
        while (it2.hasNext()) {
            MemoEntry memoEntry = (MemoEntry) it2.next();
            sb.append("MemoItem:");
            sb.append(memoEntry.toString());
        }
        return sb.toString();
    }
}
