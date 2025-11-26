package com.sec.chaton.p028io.entry;

import com.sec.chaton.p028io.entry.inner.Msg;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetUnReadMessageList extends Entry {

    @EntryField(type = Msg.class)
    public ArrayList msg = new ArrayList();
}
