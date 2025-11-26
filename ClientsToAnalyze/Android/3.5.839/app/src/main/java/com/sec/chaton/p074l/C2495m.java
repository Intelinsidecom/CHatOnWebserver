package com.sec.chaton.p074l;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;

/* compiled from: MigrationWorker.java */
/* renamed from: com.sec.chaton.l.m */
/* loaded from: classes.dex */
class C2495m implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ List f8944a;

    /* renamed from: b */
    final /* synthetic */ CallableC2494l f8945b;

    C2495m(CallableC2494l callableC2494l, List list) {
        this.f8945b = callableC2494l;
        this.f8944a = list;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        Iterator it = this.f8944a.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next()) && str.contains("_chat_profile.png_")) {
                return true;
            }
        }
        return false;
    }
}
