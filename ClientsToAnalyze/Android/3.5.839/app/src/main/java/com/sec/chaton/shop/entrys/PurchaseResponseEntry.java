package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class PurchaseResponseEntry extends Entry {
    public long itemId;
    public long itemType;
    public String marketCode;
    public String purchaseData;
    public int purchaseState;
    public String shopOrderId;
    public String signature;

    @Deprecated
    public PurchaseResponseEntry(long j, long j2, String str, String str2, String str3) {
        this.itemType = j;
        this.itemId = j2;
        this.purchaseData = str;
        this.marketCode = str2;
        this.signature = str3;
    }

    public PurchaseResponseEntry(long j, long j2, int i, String str, String str2, String str3, String str4) {
        this.itemType = j;
        this.itemId = j2;
        this.purchaseState = i;
        this.purchaseData = str;
        this.marketCode = str2;
        this.signature = str3;
        this.shopOrderId = str4;
    }

    public PurchaseResponseEntry(long j, long j2, int i, String str, String str2, String str3) {
        this.itemType = j;
        this.itemId = j2;
        this.purchaseState = i;
        this.purchaseData = str;
        this.marketCode = str2;
        this.signature = str3;
    }
}
