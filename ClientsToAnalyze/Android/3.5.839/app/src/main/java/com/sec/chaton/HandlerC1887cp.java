package com.sec.chaton;

import android.os.Message;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cp */
/* loaded from: classes.dex */
class HandlerC1887cp extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7104a;

    HandlerC1887cp(SplashActivity splashActivity) {
        this.f7104a = splashActivity;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
        if (C4904y.f17872b) {
            C4904y.m18639b("[handlerTimeOut] result : " + zBooleanValue, SplashActivity.f2006p);
        }
        if (this.f7104a.f2016r && !this.f7104a.f2017s) {
            this.f7104a.f2017s = true;
            this.f7104a.unregisterReceiver(this.f7104a.f2012F);
        }
        if (!zBooleanValue) {
            C4809aa.m18104a().m18125b("chaton_sa_is_valid", Boolean.valueOf(zBooleanValue));
            this.f7104a.m2990l();
        }
    }
}
