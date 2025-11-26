package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.a */
/* loaded from: classes.dex */
class HandlerC2386a extends HandlerC3176ar {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f8898a;

    HandlerC2386a(BackGroundRegiService backGroundRegiService) {
        this.f8898a = backGroundRegiService;
    }

    @Override // com.sec.chaton.util.HandlerC3176ar
    /* renamed from: a */
    public void mo3031a(Message message) {
        if (message.what == 1001) {
            if (!((Boolean) message.obj).booleanValue()) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m11493l().getSystemService("connectivity")).getActiveNetworkInfo();
                C3250y.m11450b("Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), BackGroundRegiService.f8872a);
            } else {
                C3250y.m11450b("Push registration success.", BackGroundRegiService.f8872a);
            }
            this.f8898a.f8879h.m5617b();
            return;
        }
        if (message.what == 1002) {
            if (((Boolean) message.obj).booleanValue()) {
                C3250y.m11450b("Push deregistration is success. execute chaton deregistration.", BackGroundRegiService.f8872a);
                this.f8898a.f8880i = this.f8898a.f8877f.m5596a();
            } else {
                C3250y.m11450b("Push deregistration is fail", BackGroundRegiService.f8872a);
                C3159aa.m10963a("back_deregi_fail", (Boolean) true);
                this.f8898a.stopSelf();
            }
        }
    }
}
