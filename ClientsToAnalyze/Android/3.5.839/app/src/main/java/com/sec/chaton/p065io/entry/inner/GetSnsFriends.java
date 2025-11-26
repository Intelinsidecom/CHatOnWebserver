package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class GetSnsFriends extends Entry {
    public String snsid;

    /* renamed from: sp */
    public String f8569sp;
    public String userid;
    public String username;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sp : " + this.f8569sp + "\t");
        sb.append("snsid : " + this.snsid + "\t");
        sb.append("userid :" + this.userid + "\t");
        sb.append("username" + this.username + "\t");
        return sb.toString();
    }
}
