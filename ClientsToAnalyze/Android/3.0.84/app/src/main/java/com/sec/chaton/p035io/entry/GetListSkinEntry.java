package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Skin;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetListSkinEntry extends Entry {
    public Long count;

    @EntryParserInfo(name = "skin")
    public List<Skin> skins = new ArrayList();
}
