package com.sec.chaton.trunk.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;

/* loaded from: classes.dex */
public class Comment extends Entry {
    public String cid;
    public String content;
    public String itemid;
    public Long regdttm;

    @EntryParserInfo(name = "writer")
    public User user = new User();
}
