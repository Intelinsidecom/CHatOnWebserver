package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.Server;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetSSMServerAddress3 extends Entry {
    public Long expdate;
    public String msisdn;

    @EntryField(type = Server.class)
    public ArrayList primary = new ArrayList();

    @EntryField(type = Server.class)
    public ArrayList secondary = new ArrayList();
    public String selfsmspn;

    @Override // com.sec.chaton.p028io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("expdate:");
        sb.append(this.expdate);
        sb.append("\n");
        for (int i = 0; i < this.primary.size(); i++) {
            sb.append("primary.ServerInfo:");
            sb.append(((Server) this.primary.get(i)).toString());
        }
        for (int i2 = 0; i2 < this.secondary.size(); i2++) {
            sb.append("secondary.ServerInfo:");
            sb.append(((Server) this.secondary.get(i2)).toString());
        }
        return sb.toString();
    }
}
