package com.sec.chaton.service;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatONVService.java */
/* renamed from: com.sec.chaton.service.e */
/* loaded from: classes.dex */
class HandlerC3418e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONVService f12432a;

    HandlerC3418e(ChatONVService chatONVService) {
        this.f12432a = chatONVService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 305:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("setExtrainfo success", ChatONVService.f12415a);
                    }
                    this.f12432a.m13286b();
                    break;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("setExtrainfo fail", ChatONVService.f12415a);
                    }
                    this.f12432a.m13286b();
                    break;
                }
                break;
            case 411:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("get profile all", ChatONVService.f12415a);
                    }
                    if (C4859bx.m18369a(this.f12432a.f12416b, this.f12432a.f12417c) != 0) {
                        this.f12432a.m13286b();
                        break;
                    }
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("get profile all fail", ChatONVService.f12415a);
                    }
                    this.f12432a.m13286b();
                    break;
                }
                break;
        }
    }
}
