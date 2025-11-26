package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.PostONCommentList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetPostONCommentList extends Entry {

    @EntryField(type = PostONCommentList.class)
    public ArrayList<PostONCommentList> commentlist = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONCommentList> it = this.commentlist.iterator();
        while (it.hasNext()) {
            PostONCommentList next = it.next();
            sb.append("PostONCommentList:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
