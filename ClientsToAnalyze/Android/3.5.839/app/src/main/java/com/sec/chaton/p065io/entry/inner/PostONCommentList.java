package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PostONCommentList extends Entry {

    @EntryField(type = PostONComment.class)
    public ArrayList<PostONComment> comment = new ArrayList<>();
    public String endtime;
    public String hasmore;
    public String isblind;
    public String totalcount;
}
