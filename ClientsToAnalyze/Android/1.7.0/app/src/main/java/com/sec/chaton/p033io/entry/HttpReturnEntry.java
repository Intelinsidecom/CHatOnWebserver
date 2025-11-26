package com.sec.chaton.p033io.entry;

/* loaded from: classes.dex */
public class HttpReturnEntry {
    public Entry bodyEntry;
    public Integer methodCode;

    public HttpReturnEntry(int i, Entry entry) {
        this.methodCode = Integer.valueOf(i);
        this.bodyEntry = entry;
    }
}
