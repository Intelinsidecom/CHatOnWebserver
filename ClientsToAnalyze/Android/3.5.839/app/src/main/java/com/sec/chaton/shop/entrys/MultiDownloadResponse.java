package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.shop.items.Item;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MultiDownloadResponse extends Entry {
    public ArrayList<Item> item;

    public MultiDownloadResponse(ArrayList<Item> arrayList) {
        this.item = new ArrayList<>();
        this.item = arrayList;
    }
}
