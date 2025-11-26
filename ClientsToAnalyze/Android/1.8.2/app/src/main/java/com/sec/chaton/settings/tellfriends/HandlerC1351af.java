package com.sec.chaton.settings.tellfriends;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: SNSIDSet.java */
/* renamed from: com.sec.chaton.settings.tellfriends.af */
/* loaded from: classes.dex */
class HandlerC1351af extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1350ae f5168a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1351af(C1350ae c1350ae, Looper looper) {
        super(looper);
        this.f5168a = c1350ae;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 313:
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    this.f5168a.m5084a(this.f5168a.f5167k, false);
                    break;
                } else {
                    this.f5168a.m5084a(this.f5168a.f5167k, true);
                    break;
                }
                break;
        }
    }
}
