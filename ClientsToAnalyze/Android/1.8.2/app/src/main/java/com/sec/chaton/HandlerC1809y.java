package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.y */
/* loaded from: classes.dex */
class HandlerC1809y extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f6501a;

    HandlerC1809y(HomeActivity homeActivity) {
        this.f6501a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((C0101b) message.obj).m665b() == EnumC0803m.SUCCESS) {
            this.f6501a.f224o.m5930a("set_compatibility");
        }
    }
}
