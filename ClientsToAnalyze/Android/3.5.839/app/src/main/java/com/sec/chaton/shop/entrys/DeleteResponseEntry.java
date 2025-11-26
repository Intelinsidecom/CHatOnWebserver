package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class DeleteResponseEntry extends Entry {
    public long itemId;
    public long itemType;

    public DeleteResponseEntry(long j, long j2) {
        this.itemType = j;
        this.itemId = j2;
    }
}
