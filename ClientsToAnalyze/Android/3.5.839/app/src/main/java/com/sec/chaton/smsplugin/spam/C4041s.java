package com.sec.chaton.smsplugin.spam;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.s */
/* loaded from: classes.dex */
class C4041s extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14555a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4041s(SetupSpamKeywordList setupSpamKeywordList, Handler handler) {
        super(handler);
        this.f14555a = setupSpamKeywordList;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f14555a.f14312m = true;
    }
}
