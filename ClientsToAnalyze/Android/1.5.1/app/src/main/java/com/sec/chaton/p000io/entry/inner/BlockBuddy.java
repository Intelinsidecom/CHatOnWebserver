package com.sec.chaton.p000io.entry.inner;

import com.sec.chaton.p000io.entry.Entry;

/* loaded from: classes.dex */
public class BlockBuddy extends Entry {
    public String name;
    public String orgnum;

    @Override // com.sec.chaton.p000io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name : " + this.name + "\t");
        sb.append("orgnum : " + this.orgnum);
        return sb.toString();
    }
}
