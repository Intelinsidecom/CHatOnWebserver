package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.FontFilter;
import com.sec.chaton.p065io.entry.inner.FontPackage;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetFontListEntry extends Entry {
    public FontFilterList fontfilterlist;
    public FontList fontlist;

    public class FontFilterList extends Entry {
        Integer count;

        @EntryParserInfo(name = "fontfilter")
        public List<FontFilter> fontFilter = new ArrayList();
    }

    public class FontList extends Entry {
        Integer count;
        public List<FontPackage> font = new ArrayList();
    }
}
