package com.sec.chaton.trunk.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CommentList extends Entry {

    @EntryParserInfo(name = "comment")
    public List<Comment> comment = new ArrayList();
}
