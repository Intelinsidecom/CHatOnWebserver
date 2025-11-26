package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bl */
/* loaded from: classes.dex */
class HandlerC0471bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1539a;

    HandlerC0471bl(TabActivity tabActivity) {
        this.f1539a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((C0267d) message.obj).m1351b() == EnumC1587o.SUCCESS) {
            this.f1539a.f761ab.m11167b("set_compatibility");
        }
    }
}
