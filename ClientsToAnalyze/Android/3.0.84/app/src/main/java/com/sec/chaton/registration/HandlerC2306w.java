package com.sec.chaton.registration;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.samsungaccount.EnumC2335ax;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.w */
/* loaded from: classes.dex */
class HandlerC2306w extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8613a;

    HandlerC2306w(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8613a = activitySyncSignInPopup;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (!this.f8613a.f8101F) {
            C0267d c0267d = (C0267d) message.obj;
            if (this.f8613a.f8124m != null && this.f8613a.f8124m.isShowing()) {
                this.f8613a.f8124m.dismiss();
            }
            if (message.what == 206) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    MainActivity.m8733a(this.f8613a.f8118g, EnumC2335ax.normal);
                    return;
                }
                CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0267d.m1354e();
                if (checkInRegisterParamEntry == null) {
                    MainActivity.m8733a(this.f8613a.f8118g, EnumC2335ax.normal);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkin result is null", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (checkInRegisterParamEntry.exist_imei == null || !checkInRegisterParamEntry.exist_imei.booleanValue()) {
                    this.f8613a.m8407b(true);
                    return;
                }
                if (GlobalApplication.m11493l() != null) {
                    AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f8613a.f8118g);
                    abstractC3271aM11494a.mo11500a(this.f8613a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8613a.getResources().getString(R.string.mum_already_registered_samsungaccount, this.f8613a.f8133v, this.f8613a.f8133v)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2308y(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2307x(this)).mo11505a();
                    if (!this.f8613a.f8101F) {
                        abstractC3271aM11494a.mo11512b();
                    }
                }
            }
        }
    }
}
