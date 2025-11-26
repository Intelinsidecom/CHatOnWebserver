package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryField;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONMultimediaList extends Entry {

    @EntryField(type = PostONMultimediaEntry.class)
    public ArrayList<PostONMultimediaEntry> multimedia = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<PostONMultimediaEntry> it = this.multimedia.iterator();
        while (it.hasNext()) {
            PostONMultimediaEntry next = it.next();
            sb.append("multimedialist:");
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
