package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.Trunk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TrunkList extends Entry {

    @EntryParserInfo(name = "trunk")
    public List<Trunk> trunks = new ArrayList();
}
