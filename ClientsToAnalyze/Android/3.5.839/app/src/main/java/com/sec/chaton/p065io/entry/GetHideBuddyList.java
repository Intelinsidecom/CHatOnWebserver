package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.HideBuddy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetHideBuddyList extends Entry {

    @EntryField(type = HideBuddy.class)
    public ArrayList<HideBuddy> buddy = new ArrayList<>();
    public String totalCount;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.buddy.size()) {
                sb.append("Hided Buddy:");
                sb.append(this.buddy.get(i2).toString());
                sb.append("\n");
                i = i2 + 1;
            } else {
                sb.append("totalCount:");
                sb.append(this.totalCount);
                sb.append("\n");
                return sb.toString();
            }
        }
    }
}
