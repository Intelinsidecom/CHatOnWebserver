package com.sec.chaton.chat;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ar */
/* loaded from: classes.dex */
class C0940ar implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3886a;

    C0940ar(ChatFragment chatFragment) {
        this.f3886a = chatFragment;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f3886a.f3703r);
    }
}
