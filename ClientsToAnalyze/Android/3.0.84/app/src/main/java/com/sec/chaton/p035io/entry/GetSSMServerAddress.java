package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Server;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetSSMServerAddress extends Entry {
    public Long expdate;

    @EntryField(type = Server.class)
    public ArrayList<Server> primary = new ArrayList<>();

    @EntryField(type = Server.class)
    public ArrayList<Server> secondary = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("expdate:");
        sb.append(this.expdate);
        sb.append("\n");
        for (int i = 0; i < this.primary.size(); i++) {
            sb.append("primary.ServerInfo:");
            sb.append(this.primary.get(i).toString());
        }
        for (int i2 = 0; i2 < this.secondary.size(); i2++) {
            sb.append("secondary.ServerInfo:");
            sb.append(this.secondary.get(i2).toString());
        }
        return sb.toString();
    }
}
