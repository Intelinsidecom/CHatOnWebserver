package com.sec.chaton.trunk.entry;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.TrunkItemComment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetCommentListEntry extends Entry {

    @EntryParserInfo(name = "item")
    public TrunkItemComment trunkitemcomment = new TrunkItemComment();

    @EntryParserInfo(name = "comment")
    public List<Comment> comments = new ArrayList();
}
