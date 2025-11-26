package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.Group;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetGroupImageStatusList extends Entry {

    @EntryField(type = Group.class)
    public ArrayList<Group> group = new ArrayList<>();
    public Long timestamp = new Long(0);
    public Integer totalcount = new Integer(0);

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("timestamp:");
        sb.append(this.timestamp);
        sb.append("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.group.size()) {
                sb.append("group.groupImageStatusInfo:");
                sb.append(this.group.get(i2).toString());
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }
}
