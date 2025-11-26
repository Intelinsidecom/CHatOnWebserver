package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4863ca;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.c */
/* loaded from: classes.dex */
class C3375c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12332a;

    C3375c(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12332a = abstractMultiDeviceActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceive : mBackRegiReceiver, bundle : " + extras, this.f12332a.f12139ae);
        }
        if (extras != null) {
            if (extras.getString("mode").equals("start")) {
                this.f12332a.m13147p();
                return;
            }
            this.f12332a.m13148q();
            if (C4859bx.m18374a().equals(EnumC4863ca.SUCCESS)) {
                this.f12332a.mo13144m();
            }
        }
    }
}
