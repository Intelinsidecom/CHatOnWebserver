package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.BuddyPreview;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetBuddyPreviewList extends Entry {

    @EntryField(type = BuddyPreview.class)
    public ArrayList<BuddyPreview> buddy = new ArrayList<>();
    public Long timestamp;

    @Override // com.sec.chaton.p035io.entry.Entry
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
