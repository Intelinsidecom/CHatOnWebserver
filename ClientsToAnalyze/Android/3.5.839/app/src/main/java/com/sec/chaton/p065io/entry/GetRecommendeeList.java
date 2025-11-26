package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.Recommendee;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetRecommendeeList extends Entry {

    @EntryField(type = Recommendee.class)
    public ArrayList<Recommendee> recommendee = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.recommendee.size()) {
                sb.append("recommendee:");
                sb.append(this.recommendee.get(i2).toString());
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }
}
