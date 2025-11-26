package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.Badge;
import com.sec.chaton.p035io.entry.inner.NewFeature;
import com.sec.chaton.p035io.entry.inner.TrunkList;

/* loaded from: classes.dex */
public class NotificationEntry extends Entry {
    public String utctimestamp;
    public Badge badge = new Badge();
    public TrunkList trunklist = new TrunkList();
    public NewFeature newfeaturelist = new NewFeature();
}
