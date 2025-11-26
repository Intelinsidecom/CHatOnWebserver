package com.sec.chaton.trunk.entry;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.Comment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetCommentListEntry extends Entry {

    @EntryParserInfo(name = "comment")
    public List<Comment> comments = new ArrayList();
}
