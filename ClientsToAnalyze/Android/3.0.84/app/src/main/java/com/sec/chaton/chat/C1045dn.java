package com.sec.chaton.chat;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dn */
/* loaded from: classes.dex */
class C1045dn implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4156a;

    C1045dn(ChatInfoFragment chatInfoFragment) {
        this.f4156a = chatInfoFragment;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4156a.f3742j);
    }
}
