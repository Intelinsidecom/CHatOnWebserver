package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.bn */
/* loaded from: classes.dex */
class C2649bn extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f9507a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2649bn(MsgboxSelectionFragment msgboxSelectionFragment, Handler handler) {
        super(handler);
        this.f9507a = msgboxSelectionFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f9507a.m11122i();
    }
}
