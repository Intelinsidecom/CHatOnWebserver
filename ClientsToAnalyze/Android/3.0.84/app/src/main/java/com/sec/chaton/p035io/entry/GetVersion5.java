package com.sec.chaton.p035io.entry;

/* loaded from: classes.dex */
public class GetVersion5 extends GetVersion {
    public String expiredkey;

    @Override // com.sec.chaton.p035io.entry.GetVersion, com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("expiredkey : " + this.expiredkey + "\n");
        return sb.toString();
    }
}
