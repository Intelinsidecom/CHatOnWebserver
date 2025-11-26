package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.h */
/* loaded from: classes.dex */
class HandlerC0866h extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3387a;

    HandlerC0866h(CallLogDetailFragment callLogDetailFragment) {
        this.f3387a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f3387a.m4548t();
        ((InterfaceC0868j) this.f3387a.getActivity()).mo4503c();
    }
}
