package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.ChatMember;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChatMembersEntry extends Entry {

    @EntryParserInfo(name = "member")
    public List<ChatMember> memberList = new ArrayList();
    public Long timestamp;
}
