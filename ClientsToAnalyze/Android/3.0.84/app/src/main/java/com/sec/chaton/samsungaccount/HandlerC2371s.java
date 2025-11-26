package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.s */
/* loaded from: classes.dex */
class HandlerC2371s extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8829a;

    HandlerC2371s(MainActivity mainActivity) {
        this.f8829a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (!this.f8829a.f8695aq) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 206) {
                this.f8829a.m8806u();
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    MainActivity.m8733a(this.f8829a.f8714k, EnumC2335ax.normal);
                    return;
                }
                CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0267d.m1354e();
                if (checkInRegisterParamEntry == null) {
                    MainActivity.m8733a(this.f8829a.f8714k, EnumC2335ax.normal);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkin result is null", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (checkInRegisterParamEntry.exist_imei == null || !checkInRegisterParamEntry.exist_imei.booleanValue()) {
                    if (this.f8829a.f8665P) {
                        this.f8829a.m8777f();
                        return;
                    } else {
                        this.f8829a.m8765c(true);
                        return;
                    }
                }
                if (GlobalApplication.m11493l() != null) {
                    this.f8829a.f8689ak = AbstractC3271a.m11494a(this.f8829a.f8714k).mo11500a(this.f8829a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8829a.getResources().getString(R.string.mum_already_registered_samsungaccount, this.f8829a.f8655F, this.f8829a.f8655F)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2373u(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2372t(this)).mo11505a();
                    if (!this.f8829a.f8695aq) {
                        this.f8829a.f8689ak.show();
                        return;
                    }
                    return;
                }
                return;
            }
            if (message.what == 207) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    MainActivity.m8733a(this.f8829a.f8714k, EnumC2335ax.normal);
                    return;
                }
                CheckInRegisterParamEntry checkInRegisterParamEntry2 = (CheckInRegisterParamEntry) c0267d.m1354e();
                if (checkInRegisterParamEntry2 == null) {
                    MainActivity.m8733a(this.f8829a.f8714k, EnumC2335ax.normal);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkin result is null", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (checkInRegisterParamEntry2.exist_imei == null || !checkInRegisterParamEntry2.exist_imei.booleanValue()) {
                    this.f8829a.m8781h();
                } else if (GlobalApplication.m11493l() != null) {
                    this.f8829a.f8689ak = AbstractC3271a.m11494a(this.f8829a.f8714k).mo11500a(this.f8829a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8829a.getResources().getString(R.string.mum_already_registered_samsungaccount, this.f8829a.f8655F, this.f8829a.f8655F)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2375w(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2374v(this)).mo11505a();
                    if (!this.f8829a.f8695aq) {
                        this.f8829a.f8689ak.show();
                    }
                }
            }
        }
    }
}
