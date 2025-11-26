package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;

/* loaded from: classes.dex */
public class GetSnsFriends extends Entry {
    public String snsid;

    /* renamed from: sp */
    public String f5647sp;
    public String userid;
    public String username;

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sp : " + this.f5647sp + "\t");
        sb.append("snsid : " + this.snsid + "\t");
        sb.append("userid :" + this.userid + "\t");
        sb.append("username" + this.username + "\t");
        return sb.toString();
    }
}
