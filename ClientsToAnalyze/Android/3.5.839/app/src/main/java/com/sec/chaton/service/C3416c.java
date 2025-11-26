package com.sec.chaton.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.c */
/* loaded from: classes.dex */
class C3416c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f12430a;

    C3416c(BackGroundRegiService backGroundRegiService) {
        this.f12430a = backGroundRegiService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("auth_token");
        C4904y.m18639b(" authToken : " + stringExtra, BackGroundRegiService.f12400a);
        if (TextUtils.isEmpty(stringExtra)) {
            this.f12430a.m13269c(false);
            return;
        }
        String stringExtra2 = intent.getStringExtra("email_id");
        String stringExtra3 = intent.getStringExtra("mcc");
        String stringExtra4 = intent.getStringExtra("api_server_url");
        C4809aa.m18108a("samsung_account_token", stringExtra);
        C4809aa.m18108a("samsung_account_email", stringExtra2);
        C4809aa.m18108a("samsung_account_api_server", stringExtra4);
        C4859bx.m18381a(GlobalApplication.m18732r(), stringExtra3);
        this.f12430a.f12404e.mo9077a(this.f12430a.f12410k);
        this.f12430a.f12410k.m18263a(1001, 30000);
    }
}
