package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;

/* loaded from: classes.dex */
public class PostONDetailEntry extends Entry {
    public String commentreadcount;
    public String commentunreadcount;
    public String imgstatus;
    public Long order_msec;
    public String postonid;
    public String postonmessage;
    public String read_msec;
    public String regdttm;
    public String sender;
    public String sendername;
    public String totalmoodcount;
    public String unreadmoodcount;

    @EntryField(type = PostONMultimediaList.class)
    public PostONMultimediaList multimedialist = new PostONMultimediaList();

    @EntryField(type = PostONCommentList.class)
    public PostONCommentList commentlist = new PostONCommentList();
}
