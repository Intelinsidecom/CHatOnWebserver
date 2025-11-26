package com.sec.chaton.smsplugin.transaction;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;

/* compiled from: SmsRetrieveService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ah */
/* loaded from: classes.dex */
final class HandlerC4057ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ SmsRetrieveService f14631a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4057ah(SmsRetrieveService smsRetrieveService, Looper looper) {
        super(looper);
        this.f14631a = smsRetrieveService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.arg1;
        Intent intent = (Intent) message.obj;
        C3890m.m14994a("handleMessage serviceId: " + i + " intent: " + intent, SmsRetrieveService.f14590b);
        if (intent == null) {
            SmsReceiver.m15543a(this.f14631a, i);
            return;
        }
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("errorCode", 0);
        C3896s.m15046d("handleMessage action: " + action + " error: " + intExtra, SmsRetrieveService.f14590b);
        if (!"android.provider.Telephony.SMS_RECEIVED".equals(action) || this.f14631a.m15577a(intent, i, intExtra)) {
            SmsReceiver.m15543a(this.f14631a, i);
        }
    }
}
