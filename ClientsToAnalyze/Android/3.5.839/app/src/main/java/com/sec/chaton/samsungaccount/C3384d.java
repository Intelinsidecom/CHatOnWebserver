package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.d */
/* loaded from: classes.dex */
class C3384d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12344a;

    C3384d(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12344a = abstractMultiDeviceActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f12344a.f12170x && this.f12344a.f12150ap) {
            this.f12344a.f12150ap = false;
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.getBoolean("isCritical")) {
                    this.f12344a.finish();
                    return;
                }
                int i = extras.getInt("which_service");
                this.f12344a.m13147p();
                if (i == 0) {
                    if (this.f12344a.f12132X) {
                        this.f12344a.m13059D();
                        return;
                    }
                    this.f12344a.m13075a(R.string.auto_regi_checking_account);
                    this.f12344a.f12124P.mo9077a(this.f12344a.f12160az);
                    this.f12344a.f12160az.m18263a(1001, 30000);
                    return;
                }
                if (i == 2) {
                    this.f12344a.f12124P.mo9077a(this.f12344a.f12160az);
                    this.f12344a.f12160az.m18263a(1001, 30000);
                    return;
                }
                return;
            }
            this.f12344a.finish();
        }
    }
}
