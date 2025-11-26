package com.sec.chaton.chat;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ch */
/* loaded from: classes.dex */
class C1012ch implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4087a;

    C1012ch(ChatFragment chatFragment) {
        this.f4087a = chatFragment;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4087a.f3703r);
    }
}
