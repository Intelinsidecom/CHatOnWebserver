package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dx */
/* loaded from: classes.dex */
class HandlerC2169dx extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7798a;

    HandlerC2169dx(TabActivity tabActivity) {
        this.f7798a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((C0778b) message.obj).m3107b() == EnumC2464o.SUCCESS) {
            this.f7798a.f2073aj.m18342b("set_compatibility");
        }
    }
}
