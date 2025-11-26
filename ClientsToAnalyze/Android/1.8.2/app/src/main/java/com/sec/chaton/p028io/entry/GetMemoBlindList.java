package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.MemoBlindEntry;
import com.sec.chaton.p028io.entry.inner.MemoBlindListEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetMemoBlindList {

    @EntryField(type = MemoBlindListEntry.class)
    public ArrayList blindlist = new ArrayList();

    @EntryField(type = MemoBlindEntry.class)
    public ArrayList blind = new ArrayList();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.blindlist.iterator();
        while (it.hasNext()) {
            MemoBlindListEntry memoBlindListEntry = (MemoBlindListEntry) it.next();
            sb.append("MemoBlindList:");
            sb.append(memoBlindListEntry.toString());
        }
        sb.append("\n");
        Iterator it2 = this.blind.iterator();
        while (it2.hasNext()) {
            MemoBlindEntry memoBlindEntry = (MemoBlindEntry) it2.next();
            sb.append("MemoBlindItem:");
            sb.append(memoBlindEntry.toString());
        }
        return sb.toString();
    }
}
