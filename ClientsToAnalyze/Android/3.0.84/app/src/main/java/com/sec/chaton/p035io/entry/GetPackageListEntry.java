package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Package;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetPackageListEntry extends Entry {

    @EntryParserInfo(name = "package")
    public List<Package> packges = new ArrayList();
}
