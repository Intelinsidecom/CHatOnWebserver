package com.sec.chaton.facebook;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.settings.tellfriends.C1350ae;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.g */
/* loaded from: classes.dex */
class HandlerC0726g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0725f f2706a;

    HandlerC0726g(C0725f c0725f) {
        this.f2706a = c0725f;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 313:
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    C1350ae.m5081a(this.f2706a.f2703c).m5084a(this.f2706a.m3216a(), false);
                    break;
                } else {
                    C1350ae.m5081a(this.f2706a.f2703c).m5084a(this.f2706a.m3216a(), true);
                    break;
                }
                break;
        }
    }
}
