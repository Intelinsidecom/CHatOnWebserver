package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.PostONBlind;
import com.sec.chaton.p035io.entry.inner.PostONBlindList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetPostONBlindList {

    @EntryField(type = PostONBlindList.class)
    public ArrayList<PostONBlindList> blindlist = new ArrayList<>();

    @EntryField(type = PostONBlind.class)
    public ArrayList<PostONBlind> blind = new ArrayList<>();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONBlindList> it = this.blindlist.iterator();
        while (it.hasNext()) {
            PostONBlindList next = it.next();
            sb.append("PostONBlindList:");
            sb.append(next.toString());
        }
        sb.append("\n");
        Iterator<PostONBlind> it2 = this.blind.iterator();
        while (it2.hasNext()) {
            PostONBlind next2 = it2.next();
            sb.append("PostONBlindItem:");
            sb.append(next2.toString());
        }
        return sb.toString();
    }
}
