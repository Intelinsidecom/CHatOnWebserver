package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.s */
/* loaded from: classes.dex */
class HandlerC3399s extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12360a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3399s(AbstractMultiDeviceActivity abstractMultiDeviceActivity, Looper looper) {
        super(looper);
        this.f12360a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b;
        GetVersionNotice getVersionNotice;
        if (!this.f12360a.f12166t && (c0778b = (C0778b) message.obj) != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && (getVersionNotice = (GetVersionNotice) c0778b.m3110e()) != null) {
            if ((getVersionNotice.uptodate != null && getVersionNotice.uptodate.booleanValue()) || (getVersionNotice.critical != null && !getVersionNotice.critical.booleanValue())) {
                C4822an.m18256x();
                this.f12360a.m13139z();
            }
        }
    }
}
