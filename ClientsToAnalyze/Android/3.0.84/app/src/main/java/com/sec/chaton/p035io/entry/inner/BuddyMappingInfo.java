package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryField;
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
