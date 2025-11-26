package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.aw */
/* loaded from: classes.dex */
class HandlerC2982aw extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10782a;

    HandlerC2982aw(TrunkFullView trunkFullView) {
        this.f10782a = trunkFullView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10782a.m10223h() != null && !this.f10782a.m10223h().isFinishing() && message.obj != null && message.obj.equals(this.f10782a.f10532K) && this.f10782a.f10536O != null) {
            this.f10782a.f10540a.setVisibility(0);
            this.f10782a.f10531J.m11730a(this.f10782a.f10540a, this.f10782a.f10536O);
        }
    }
}
