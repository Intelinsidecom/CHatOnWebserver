package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.shop.items.ItemMarket;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PurchaseRequestEntry extends Entry {
    public String error;
    public long itemId;
    public long itemType;
    public ArrayList<ItemMarket> market = new ArrayList<>();
    public int purchaseType;
    public String success;
}
