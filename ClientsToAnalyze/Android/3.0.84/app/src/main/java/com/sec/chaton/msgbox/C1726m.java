package com.sec.chaton.msgbox;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.m */
/* loaded from: classes.dex */
class C1726m implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6392a;

    C1726m(MsgboxFragment msgboxFragment) {
        this.f6392a = msgboxFragment;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f6392a.f6278r);
    }
}
