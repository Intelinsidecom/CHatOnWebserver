package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryField;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONEntry extends Entry {
    public String commentreadcount;
    public String commentunreadcount;
    public String imgstatus;

    @EntryField(type = PostONMultimediaList.class)
    public ArrayList<PostONMultimediaList> multimedialist = new ArrayList<>();
    public String postonid;
    public String postonmessage;
    public String read_msec;
    public String regdttm;
    public String sender;
    public String sendername;
    public String totalmoodcount;
    public String unreadmoodcount;

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONMultimediaList> it = this.multimedialist.iterator();
        while (it.hasNext()) {
            PostONMultimediaList next = it.next();
            sb.append("multimedialist:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
