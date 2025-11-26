package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.a */
/* loaded from: classes.dex */
class HandlerC0775a extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f2101a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0775a(AdminMenu adminMenu, Looper looper) {
        super(looper);
        this.f2101a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            if (GlobalApplication.f8355a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                this.f2101a.f1869F.setText("Push Status - Available");
            } else {
                this.f2101a.f1869F.setText("Push Status - Unvailable");
            }
        }
    }
}
