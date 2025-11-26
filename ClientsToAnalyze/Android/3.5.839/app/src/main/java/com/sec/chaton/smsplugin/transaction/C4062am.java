package com.sec.chaton.smsplugin.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: TransactionService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.am */
/* loaded from: classes.dex */
class C4062am extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TransactionService f14645a;

    private C4062am(TransactionService transactionService) {
        this.f14645a = transactionService;
    }

    /* synthetic */ C4062am(TransactionService transactionService, HandlerC4061al handlerC4061al) {
        this(transactionService);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14997c("TransactionService", "ConnectivityBroadcastReceiver.onReceive() action: " + action);
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("TransactionService", "Handle ConnectivityBroadcastReceiver.onReceive(): " + networkInfo);
            }
            if (networkInfo == null || networkInfo.getType() != 2) {
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("TransactionService", "   type is not TYPE_MOBILE_MMS, bail");
                }
                if (networkInfo != null && "2GVoiceCallEnded".equals(networkInfo.getReason())) {
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "   reason is 2GVoiceCallEnded, retrying mms connectivity");
                    }
                    this.f14645a.m15593g();
                    return;
                }
                return;
            }
            if (!networkInfo.isConnected()) {
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("TransactionService", "   TYPE_MOBILE_MMS not connected, bail");
                }
            } else {
                C4064ao c4064ao = new C4064ao(this.f14645a, networkInfo.getExtraInfo());
                if (!TextUtils.isEmpty(c4064ao.m15637a())) {
                    this.f14645a.m15593g();
                    this.f14645a.f14598b.m15635a(null, c4064ao);
                } else {
                    C3890m.m14994a("TransactionService", "   empty MMSC url, bail");
                }
            }
        }
    }
}
