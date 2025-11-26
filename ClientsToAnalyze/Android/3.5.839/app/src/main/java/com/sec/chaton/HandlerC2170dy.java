package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dy */
/* loaded from: classes.dex */
class HandlerC2170dy extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7799a;

    HandlerC2170dy(TabActivity tabActivity) {
        this.f7799a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((C0778b) message.obj).m3107b() == EnumC2464o.SUCCESS) {
            this.f7799a.f2073aj.m18342b("set_uploadPurchaseList");
        }
    }
}
