package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Badge extends Entry {

    @EntryParserInfo(name = "content")
    public List<Content> contents = new ArrayList();

    public class Content extends Entry {

        @EntryParserInfo(name = "value")
        public String _value;
        public String name;
    }
}
