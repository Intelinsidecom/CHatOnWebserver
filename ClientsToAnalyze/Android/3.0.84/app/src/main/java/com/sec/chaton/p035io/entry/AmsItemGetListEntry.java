package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.AmsItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AmsItemGetListEntry extends Entry {
    public Integer count;

    @EntryParserInfo(name = "amsitem")
    public List<AmsItem> items = new ArrayList();
    public Integer type;
}
