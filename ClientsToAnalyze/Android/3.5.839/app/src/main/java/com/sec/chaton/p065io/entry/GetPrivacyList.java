package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.PrivacyList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetPrivacyList extends Entry {

    @EntryField(type = PrivacyList.class)
    public ArrayList<PrivacyList> privacy = new ArrayList<>();

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PrivacyList> it = this.privacy.iterator();
        while (it.hasNext()) {
            PrivacyList next = it.next();
            sb.append("PrivacyList:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
