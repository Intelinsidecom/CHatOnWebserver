package com.sec.chaton.smsplugin.transaction;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.util.C4822an;

/* compiled from: SmsReceiverService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.af */
/* loaded from: classes.dex */
final class HandlerC4055af extends Handler {

    /* renamed from: a */
    final /* synthetic */ SmsReceiverService f14626a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4055af(SmsReceiverService smsReceiverService, Looper looper) {
        super(looper);
        this.f14626a = smsReceiverService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException {
        int i = message.arg1;
        Intent intent = (Intent) message.obj;
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(SmsReceiverService.f14578b, "handleMessage serviceId: " + i + " intent: " + intent);
        }
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("errorCode", 0);
            C3896s.m15045c("action = " + action, SmsReceiverService.f14578b);
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a(SmsReceiverService.f14578b, "handleMessage action: " + action + " error: " + intExtra);
            }
            if ("com.sec.chaton.smsplugin.transaction.MESSAGE_SENT".equals(intent.getAction())) {
                this.f14626a.m15556a(intent, intExtra);
            } else if ("android.provider.Telephony.SMS_DELIVER".equals(action)) {
                C3892o.m15031e();
                this.f14626a.m15566b(intent, intExtra);
            } else if (!C3892o.m15023b() && "android.provider.Telephony.SMS_RECEIVED".equals(action)) {
                this.f14626a.m15566b(intent, intExtra);
            } else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                if (!C2349a.m10301a("for_wifi_only_device") && !C4822an.m18196F()) {
                    this.f14626a.m15564b();
                }
            } else if ("android.intent.action.SERVICE_STATE".equals(action)) {
                this.f14626a.m15565b(intent);
            } else if ("com.sec.chaton.smsplugin.transaction.SEND_MESSAGE".endsWith(action)) {
                this.f14626a.m15570c(intent);
            }
        }
        SmsReceiver.m15543a(this.f14626a, i);
    }
}
