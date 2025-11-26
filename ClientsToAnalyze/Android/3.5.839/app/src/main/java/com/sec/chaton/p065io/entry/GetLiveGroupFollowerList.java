package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetLiveGroupFollowerList extends Entry {
    public Long timestamp = new Long(0);

    @EntryParserInfo(name = "follower")
    public ArrayList<LiveGroupFollower> follower = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<LiveGroupFollower> it = this.follower.iterator();
        while (it.hasNext()) {
            LiveGroupFollower next = it.next();
            sb.append("LiveGroupFollower Buddy : ");
            sb.append(next.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
