package com.sec.chaton.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.a */
/* loaded from: classes.dex */
class HandlerC3414a extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f12428a;

    HandlerC3414a(BackGroundRegiService backGroundRegiService) {
        this.f12428a = backGroundRegiService;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (message.what == 1001) {
            if (!((Boolean) message.obj).booleanValue()) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalApplication.m18732r().getSystemService("connectivity")).getActiveNetworkInfo();
                C4904y.m18639b("Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), BackGroundRegiService.f12400a);
            } else {
                C4904y.m18639b("Push registration success.", BackGroundRegiService.f12400a);
            }
            this.f12428a.f12407h.m9390b();
            return;
        }
        if (message.what == 1002) {
            if (((Boolean) message.obj).booleanValue()) {
                C4904y.m18639b("Push deregistration is success. execute chaton deregistration.", BackGroundRegiService.f12400a);
            } else {
                C4904y.m18639b("Push deregistration is fail", BackGroundRegiService.f12400a);
            }
            this.f12428a.f12408i = this.f12428a.f12405f.m9348a();
        }
    }
}
