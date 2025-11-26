package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyProfileNew extends Entry {

    @EntryField(type = Buddy.class)
    public ArrayList<Buddy> buddy = new ArrayList<>();
    public Long timestamp;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("timestamp:");
        sb.append(this.timestamp);
        sb.append("\n");
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
