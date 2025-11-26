package com.sec.chaton.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.c */
/* loaded from: classes.dex */
class C2388c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f8900a;

    C2388c(BackGroundRegiService backGroundRegiService) {
        this.f8900a = backGroundRegiService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        String stringExtra = intent.getStringExtra("auth_token");
        C3250y.m11450b(" authToken : " + stringExtra, BackGroundRegiService.f8872a);
        if (TextUtils.isEmpty(stringExtra)) {
            this.f8900a.m8882b(false);
            return;
        }
        String stringExtra2 = intent.getStringExtra("email_id");
        String stringExtra3 = intent.getStringExtra("mcc");
        String stringExtra4 = intent.getStringExtra("api_server_url");
        C3159aa.m10966a("samsung_account_token", stringExtra);
        C3159aa.m10966a("samsung_account_email", stringExtra2);
        C3159aa.m10966a("samsung_account_api_server", stringExtra4);
        C3214cb.m11251a(GlobalApplication.m11493l(), stringExtra3);
        this.f8900a.f8876e.mo5479a(this.f8900a.f8882k);
        this.f8900a.f8882k.m11091a(1001, 30000);
    }
}
