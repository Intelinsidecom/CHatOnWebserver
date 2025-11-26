package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import com.sec.chaton.p065io.entry.GetMappingInfo;
import com.sec.chaton.p065io.entry.GetProfileImageList;

/* loaded from: classes.dex */
public class ProfileInformationList extends Entry {

    @EntryField(type = BuddyProfile.class)
    public BuddyProfile profile = new BuddyProfile();

    @EntryField(type = CoverStory.class)
    public CoverStory coverstory = new CoverStory();

    @EntryField(type = GetProfileImageList.class)
    public GetProfileImageList profileimage = new GetProfileImageList();

    @EntryField(type = GetMappingInfo.class)
    public GetMappingInfo mappinginfo = new GetMappingInfo();
}
