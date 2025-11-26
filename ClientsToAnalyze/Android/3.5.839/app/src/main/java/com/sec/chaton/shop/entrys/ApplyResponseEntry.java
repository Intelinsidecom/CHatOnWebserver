package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class ApplyResponseEntry extends Entry {
    public long itemId;
    public long itemType;

    public ApplyResponseEntry(long j, long j2) {
        this.itemType = j;
        this.itemId = j2;
    }
}
