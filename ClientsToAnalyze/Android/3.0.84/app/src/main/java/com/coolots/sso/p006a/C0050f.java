package com.coolots.sso.p006a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.coolots.sso.a.f */
/* loaded from: classes.dex */
class C0050f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0045a f41a;

    private C0050f(C0045a c0045a) {
        this.f41a = c0045a;
    }

    /* synthetic */ C0050f(C0045a c0045a, C0050f c0050f) {
        this(c0045a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        C0045a.m36b("ChatONVAPIIReceiver() action: " + action);
        C0045a.m36b("ChatONVAPIIReceiver() this: " + toString());
        C0045a.m36b("ChatONVAPIIReceiver() mListener: " + this.f41a.f35c.toString());
        C0045a.m36b("ChatONVAPIIReceiver() mReceiver: " + this.f41a.f34b.toString());
        if (!action.equals("com.coolots.chaton.account.ACCOUNT_RESULTINFO")) {
            if (action.equals("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO") && intent.hasExtra("result")) {
                C0045a.m36b("BR_REMOVE_ACCOUNT_RESULT_INFO");
                if (this.f41a.f35c != null) {
                    this.f41a.f35c.onReceiveRemoveAccount(intent.getBooleanExtra("result", false));
                    return;
                }
                return;
            }
            return;
        }
        if (intent.hasExtra("result")) {
            C0045a.m36b("BR_ACCOUNT_RESULT_INFO");
            if (this.f41a.f35c != null) {
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                String stringExtra = intent.getStringExtra("account_fail_string");
                C0045a.m36b("result: " + booleanExtra + ", result string: " + stringExtra);
                this.f41a.f35c.onReceiveCreateAccount(booleanExtra, stringExtra);
            }
        }
    }
}
