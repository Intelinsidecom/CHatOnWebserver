package com.sec.chaton.smsplugin.p112ui;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: ManageSimMessages.java */
/* renamed from: com.sec.chaton.smsplugin.ui.am */
/* loaded from: classes.dex */
class C4104am extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ManageSimMessages f15235a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4104am(ManageSimMessages manageSimMessages, Handler handler) {
        super(handler);
        this.f15235a = manageSimMessages;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f15235a.m15784c();
    }
}
