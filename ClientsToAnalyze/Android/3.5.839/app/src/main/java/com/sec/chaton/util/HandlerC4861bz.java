package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.bz */
/* loaded from: classes.dex */
final class HandlerC4861bz extends Handler {
    HandlerC4861bz(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C0778b c0778b = (C0778b) message.obj;
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4809aa.m18104a().m18128b("get_version_gcm_reg_id", GlobalApplication.f8356b);
            C4904y.m18639b("Get Version success, GCM registraion id : " + GlobalApplication.f8356b, C4859bx.f17686b);
        } else {
            C4904y.m18634a("Get Version is failed, clear GCM registration id.", C4859bx.f17686b);
            GlobalApplication.f8356b = null;
        }
    }
}
