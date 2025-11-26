package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyMappingInfo extends Entry {

    @EntryField(type = MappingInfoEntry.class)
    public ArrayList<MappingInfoEntry> MappingInfo = new ArrayList<>();
    public Boolean buddysync;
    public Boolean mapping;
    public Boolean msgsync;
    public String url;
}
