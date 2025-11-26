package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Message;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetAllMessageList extends Entry {
    public Boolean has_more;

    @EntryField(type = Message.class)
    public ArrayList<Message> messages = new ArrayList<>();
}
