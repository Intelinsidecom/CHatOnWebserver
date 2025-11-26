package com.sec.chaton.p028io.entry.inner;

import com.sec.chaton.p028io.entry.Entry;
import com.sec.chaton.p028io.entry.EntryField;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class InteractionListEntry extends Entry {

    @EntryField(type = InteractionEntry.class)
    public ArrayList buddyid = new ArrayList();
    public String end;
    public String start;
    public String totalcount;
    public String week;
}
