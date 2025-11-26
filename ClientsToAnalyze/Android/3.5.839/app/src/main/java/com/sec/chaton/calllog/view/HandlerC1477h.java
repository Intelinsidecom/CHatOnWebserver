package com.sec.chaton.calllog.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.h */
/* loaded from: classes.dex */
class HandlerC1477h extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f5360a;

    HandlerC1477h(CallLogDetailFragment callLogDetailFragment) {
        this.f5360a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f5360a.m7703u();
        ((InterfaceC1479j) this.f5360a.getActivity()).mo7657h();
    }
}
