package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.x */
/* loaded from: classes.dex */
class HandlerC3404x extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12365a;

    HandlerC3404x(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12365a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (!this.f12365a.f12166t) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 206) {
                this.f12365a.m13148q();
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    AbstractMultiDeviceActivity.m13092b(this.f12365a.f12118J, EnumC3327af.normal, null, this.f12365a.f12149ao);
                    return;
                }
                CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0778b.m3110e();
                if (checkInRegisterParamEntry == null) {
                    AbstractMultiDeviceActivity.m13092b(this.f12365a.f12118J, EnumC3327af.normal, null, this.f12365a.f12149ao);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkin result is null", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (checkInRegisterParamEntry.exist_imei == null || !checkInRegisterParamEntry.exist_imei.booleanValue()) {
                    if (!this.f12365a.f12137ac) {
                        this.f12365a.m13112g(true);
                        return;
                    } else {
                        this.f12365a.m13142k();
                        return;
                    }
                }
                if (GlobalApplication.m18732r() != null) {
                    this.f12365a.f12141ag = AbstractC4932a.m18733a(this.f12365a.f12118J).mo18740a(this.f12365a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12365a.getResources().getString(R.string.mum_already_registered_samsungaccount, this.f12365a.f12133Y, this.f12365a.f12133Y)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3406z(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3405y(this)).mo18745a();
                    if (!this.f12365a.f12166t) {
                        this.f12365a.f12141ag.show();
                        return;
                    }
                    return;
                }
                return;
            }
            if (message.what == 207) {
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    AbstractMultiDeviceActivity.m13092b(this.f12365a.f12118J, EnumC3327af.normal, null, this.f12365a.f12149ao);
                    return;
                }
                CheckInRegisterParamEntry checkInRegisterParamEntry2 = (CheckInRegisterParamEntry) c0778b.m3110e();
                if (checkInRegisterParamEntry2 == null) {
                    AbstractMultiDeviceActivity.m13092b(this.f12365a.f12118J, EnumC3327af.normal, null, this.f12365a.f12149ao);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkin result is null", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (checkInRegisterParamEntry2.exist_imei != null && checkInRegisterParamEntry2.exist_imei.booleanValue()) {
                    if (GlobalApplication.m18732r() != null) {
                        this.f12365a.f12141ag = AbstractC4932a.m18733a(this.f12365a.f12118J).mo18740a(this.f12365a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12365a.getResources().getString(R.string.mum_already_registered_samsungaccount, this.f12365a.f12133Y, this.f12365a.f12133Y)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3323ab(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3322aa(this)).mo18745a();
                        if (!this.f12365a.f12166t) {
                            this.f12365a.f12141ag.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f12365a.m13143l();
            }
        }
    }
}
