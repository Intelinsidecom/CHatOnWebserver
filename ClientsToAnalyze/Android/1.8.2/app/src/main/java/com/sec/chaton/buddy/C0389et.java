package com.sec.chaton.buddy;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.et */
/* loaded from: classes.dex */
class C0389et implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f1547a;

    /* renamed from: b */
    final /* synthetic */ SpecialBuddyActivity f1548b;

    C0389et(SpecialBuddyActivity specialBuddyActivity, String str) {
        this.f1548b = specialBuddyActivity;
        this.f1547a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.equals(this.f1547a);
    }
}
