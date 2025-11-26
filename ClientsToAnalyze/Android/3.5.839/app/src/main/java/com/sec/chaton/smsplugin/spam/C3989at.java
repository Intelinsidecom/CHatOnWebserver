package com.sec.chaton.smsplugin.spam;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.at */
/* loaded from: classes.dex */
class C3989at extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14430a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3989at(SetupSpamNumberList setupSpamNumberList, Handler handler) {
        super(handler);
        this.f14430a = setupSpamNumberList;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f14430a.f14348E = true;
    }
}
