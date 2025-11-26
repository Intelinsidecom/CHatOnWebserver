package com.sec.chaton.service;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatONVService.java */
/* renamed from: com.sec.chaton.service.e */
/* loaded from: classes.dex */
class HandlerC2390e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONVService f8902a;

    HandlerC2390e(ChatONVService chatONVService) {
        this.f8902a = chatONVService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 305:
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("setExtrainfo success", ChatONVService.f8887a);
                    }
                    this.f8902a.m8901b();
                    break;
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("setExtrainfo fail", ChatONVService.f8887a);
                    }
                    this.f8902a.m8901b();
                    break;
                }
                break;
        }
    }
}
