package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NewFeature extends Entry {

    @EntryParserInfo(name = "feature")
    public List<Feature> feature = new ArrayList();
}
