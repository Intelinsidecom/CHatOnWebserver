package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.a */
/* loaded from: classes.dex */
class HandlerC0262a extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f807a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0262a(AdminMenu adminMenu, Looper looper) {
        super(looper);
        this.f807a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            if (GlobalApplication.f5511a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                this.f807a.f661r.setText("Push Status - Available");
            } else {
                this.f807a.f661r.setText("Push Status - Unvailable");
            }
        }
    }
}
