package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.p */
/* loaded from: classes.dex */
class HandlerC3396p extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12357a;

    HandlerC3396p(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12357a = abstractMultiDeviceActivity;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) throws Resources.NotFoundException {
        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
        if (C4904y.f17872b) {
            C4904y.m18639b("[handlerTimeOut] result : " + zBooleanValue, this.f12357a.f12139ae);
        }
        if (!zBooleanValue) {
            this.f12357a.m13061E();
        }
    }
}
