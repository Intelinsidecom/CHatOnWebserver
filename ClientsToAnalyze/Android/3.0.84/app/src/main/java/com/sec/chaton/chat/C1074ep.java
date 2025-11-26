package com.sec.chaton.chat;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ChatProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.chat.ep */
/* loaded from: classes.dex */
class C1074ep implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ CallableC1073eo f4314a;

    C1074ep(CallableC1073eo callableC1073eo) {
        this.f4314a = callableC1073eo;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4314a.f4312l);
    }
}
