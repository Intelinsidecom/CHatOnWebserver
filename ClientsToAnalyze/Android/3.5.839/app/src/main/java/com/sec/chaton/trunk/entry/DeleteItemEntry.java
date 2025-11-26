package com.sec.chaton.trunk.entry;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.Summary;

/* loaded from: classes.dex */
public class DeleteItemEntry extends Entry {

    @EntryParserInfo(name = "summary")
    public Summary summary = new Summary();
}
