package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.GetSnsFriends;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetSnsFriendsList extends Entry {

    @EntryField(type = GetSnsFriends.class)
    public ArrayList<GetSnsFriends> sns = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<GetSnsFriends> it = this.sns.iterator();
        while (it.hasNext()) {
            GetSnsFriends next = it.next();
            sb.append("SNS Friends List : ");
            sb.append(next.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
