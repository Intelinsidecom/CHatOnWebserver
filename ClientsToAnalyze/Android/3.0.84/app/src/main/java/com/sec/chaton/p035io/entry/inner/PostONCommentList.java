package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryField;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PostONCommentList extends Entry {

    @EntryField(type = PostONComment.class)
    public ArrayList<PostONComment> comment = new ArrayList<>();
    public String endtime;
    public String hasmore;
    public String isblind;
}
