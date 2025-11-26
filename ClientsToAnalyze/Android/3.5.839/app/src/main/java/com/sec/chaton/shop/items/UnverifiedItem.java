package com.sec.chaton.shop.items;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class UnverifiedItem extends Entry {
    public long itemId;
    public long itemType;
    public String marketCode;
    public String purchaseData;
    public String shopOrderId;
    public String signature;

    public UnverifiedItem(long j, long j2, String str, String str2, String str3, String str4) {
        this.itemType = j;
        this.itemId = j2;
        this.purchaseData = str;
        this.marketCode = str2;
        this.signature = str3;
        this.shopOrderId = str4;
    }

    public UnverifiedItem() {
    }
}
