package com.sec.chaton.chat;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.du */
/* loaded from: classes.dex */
class C1052du implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4163a;

    C1052du(ChatInfoFragment chatInfoFragment) {
        this.f4163a = chatInfoFragment;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4163a.f3742j);
    }
}
