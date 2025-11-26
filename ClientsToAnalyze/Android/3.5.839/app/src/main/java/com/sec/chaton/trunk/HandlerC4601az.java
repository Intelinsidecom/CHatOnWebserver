package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.az */
/* loaded from: classes.dex */
class HandlerC4601az extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16731a;

    HandlerC4601az(TrunkFullView trunkFullView) {
        this.f16731a = trunkFullView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16731a.m17321h() != null && !this.f16731a.m17321h().isFinishing() && message.obj != null && message.obj.equals(this.f16731a.f16478J) && this.f16731a.f16483O != null) {
            this.f16731a.f16487a.setVisibility(0);
            this.f16731a.f16477I.m19023b(this.f16731a.f16487a, this.f16731a.f16483O);
        }
    }
}
