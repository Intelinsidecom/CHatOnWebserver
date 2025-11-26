package com.sec.chaton.trunk.entry;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetItemListEntry extends Entry {

    @EntryParserInfo(name = "item")
    public List<TrunkItem> items = new ArrayList();
}
