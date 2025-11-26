package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.GetSnsFriends;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetSnsFriendsList extends Entry {

    @EntryField(type = GetSnsFriends.class)
    public ArrayList sns = new ArrayList();

    @Override // com.sec.chaton.p028io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.sns.iterator();
        while (it.hasNext()) {
            GetSnsFriends getSnsFriends = (GetSnsFriends) it.next();
            sb.append("SNS Friends List : ");
            sb.append(getSnsFriends.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
