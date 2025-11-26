package com.sec.chaton.p025d.p026a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: GetChatProfileImageTitleTask.java */
/* renamed from: com.sec.chaton.d.a.br */
/* loaded from: classes.dex */
class C1190br implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f4688a;

    /* renamed from: b */
    final /* synthetic */ C1189bq f4689b;

    C1190br(C1189bq c1189bq, String str) {
        this.f4689b = c1189bq;
        this.f4688a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        String[] strArrSplit = str.split("_chat_profile.png_.");
        return str.startsWith(this.f4689b.f4687b) && !this.f4688a.equals(strArrSplit[strArrSplit.length + (-1)]);
    }
}
