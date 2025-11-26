package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.BuddyIgnoreListEntry;
import com.sec.chaton.p028io.entry.inner.MemoBlindEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class getBuddyIgnoreList {

    @EntryField(type = BuddyIgnoreListEntry.class)
    public ArrayList ignorelist = new ArrayList();

    @EntryField(type = MemoBlindEntry.class)
    public ArrayList ignore = new ArrayList();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.ignorelist.iterator();
        while (it.hasNext()) {
            BuddyIgnoreListEntry buddyIgnoreListEntry = (BuddyIgnoreListEntry) it.next();
            sb.append("ignorelist:");
            sb.append(buddyIgnoreListEntry.toString());
        }
        sb.append("\n");
        Iterator it2 = this.ignore.iterator();
        while (it2.hasNext()) {
            MemoBlindEntry memoBlindEntry = (MemoBlindEntry) it2.next();
            sb.append("ignore:");
            sb.append(memoBlindEntry.toString());
        }
        return sb.toString();
    }
}
