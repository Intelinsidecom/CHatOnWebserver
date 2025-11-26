package com.sec.chaton.trunk.entry;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.Trunk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetTrunkListEntry extends Entry {

    @EntryParserInfo(name = "trunk")
    public List<Trunk> trunks = new ArrayList();
}
