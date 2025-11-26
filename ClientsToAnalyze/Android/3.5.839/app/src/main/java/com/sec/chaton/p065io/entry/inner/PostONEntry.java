package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;

/* loaded from: classes.dex */
public class PostONEntry extends Entry {
    public String commentreadcount;
    public String commentunreadcount;
    public String imgstatus;

    @EntryField(type = PostONMultimediaList.class)
    public PostONMultimediaList multimedialist = new PostONMultimediaList();
    public Long order_msec;
    public String postonid;
    public String postonmessage;
    public String read_msec;
    public String regdttm;
    public String sender;
    public String sendername;
    public String totalmoodcount;
    public String unreadmoodcount;

    @Override // com.sec.chaton.p065io.entry.Entry
    public String toString() {
        return "multimedialist:" + this.multimedialist.toString();
    }
}
