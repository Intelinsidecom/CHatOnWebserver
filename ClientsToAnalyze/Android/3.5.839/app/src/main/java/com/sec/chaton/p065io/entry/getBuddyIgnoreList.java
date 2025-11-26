package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.BuddyIgnoreListEntry;
import com.sec.chaton.p065io.entry.inner.PostONBlind;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class getBuddyIgnoreList {

    @EntryField(type = BuddyIgnoreListEntry.class)
    public ArrayList<BuddyIgnoreListEntry> ignorelist = new ArrayList<>();

    @EntryField(type = PostONBlind.class)
    public ArrayList<PostONBlind> ignore = new ArrayList<>();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<BuddyIgnoreListEntry> it = this.ignorelist.iterator();
        while (it.hasNext()) {
            BuddyIgnoreListEntry next = it.next();
            sb.append("ignorelist:");
            sb.append(next.toString());
        }
        sb.append("\n");
        Iterator<PostONBlind> it2 = this.ignore.iterator();
        while (it2.hasNext()) {
            PostONBlind next2 = it2.next();
            sb.append("ignore:");
            sb.append(next2.toString());
        }
        return sb.toString();
    }
}
