package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Msg;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetUnReadMessageList extends Entry {

    @EntryField(type = Msg.class)
    public ArrayList<Msg> msg = new ArrayList<>();
    public String nextstartkey;
}
