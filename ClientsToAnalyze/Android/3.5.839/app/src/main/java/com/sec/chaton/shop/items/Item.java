package com.sec.chaton.shop.items;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class Item extends Entry {
    public int isRefunded;
    public long itemId;
    public long itemType;
    public int itemVersion;

    public Item(long j, long j2, int i) {
        this.itemId = j;
        this.itemType = j2;
        this.itemVersion = i;
    }

    public Item(long j, long j2, int i, int i2) {
        this.itemId = j;
        this.itemType = j2;
        this.itemVersion = i;
        this.isRefunded = i2;
    }

    public Item() {
    }
}
