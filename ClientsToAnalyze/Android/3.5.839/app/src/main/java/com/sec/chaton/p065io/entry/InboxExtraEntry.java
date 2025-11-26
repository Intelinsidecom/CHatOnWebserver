package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.TopicChatType;

/* loaded from: classes.dex */
public class InboxExtraEntry extends Entry {

    @EntryField(type = TopicChatType.class)
    public TopicChatType topicchattype = new TopicChatType();
}
