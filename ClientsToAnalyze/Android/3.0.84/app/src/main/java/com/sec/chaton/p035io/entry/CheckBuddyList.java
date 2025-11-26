package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.CheckBuddy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CheckBuddyList extends Entry {

    @EntryField(type = CheckBuddy.class)
    public ArrayList<CheckBuddy> buddy = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.buddy.size()) {
                sb.append("buddy.BuddyInfo:");
                sb.append(this.buddy.get(i2).toString());
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }
}
