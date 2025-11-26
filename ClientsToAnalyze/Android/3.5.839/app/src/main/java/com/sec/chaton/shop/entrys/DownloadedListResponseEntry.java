package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.shop.items.UnverifiedItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DownloadedListResponseEntry extends Entry {
    public ArrayList<Item> item;
    public ArrayList<UnverifiedItem> unverifiedItem;

    @Deprecated
    public DownloadedListResponseEntry(ArrayList<Item> arrayList) {
        this.item = new ArrayList<>();
        this.unverifiedItem = new ArrayList<>();
        this.item = arrayList;
    }

    public DownloadedListResponseEntry(ArrayList<Item> arrayList, ArrayList<UnverifiedItem> arrayList2) {
        this.item = new ArrayList<>();
        this.unverifiedItem = new ArrayList<>();
        this.item = arrayList;
        this.unverifiedItem = arrayList2;
    }
}
