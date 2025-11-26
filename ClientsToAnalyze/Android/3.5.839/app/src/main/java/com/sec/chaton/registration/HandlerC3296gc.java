package com.sec.chaton.registration;

import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: RegisterSMSActivity.java */
/* renamed from: com.sec.chaton.registration.gc */
/* loaded from: classes.dex */
class HandlerC3296gc extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ RegisterSMSActivity f12064a;

    HandlerC3296gc(RegisterSMSActivity registerSMSActivity) {
        this.f12064a = registerSMSActivity;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
        if (C4904y.f17872b) {
            C4904y.m18639b("[handlerTimeOut] result : " + zBooleanValue, this.f12064a.f11848x);
        }
        if (!zBooleanValue) {
            this.f12064a.m13008f();
        }
    }
}
