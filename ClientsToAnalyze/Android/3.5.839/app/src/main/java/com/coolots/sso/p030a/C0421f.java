package com.coolots.sso.p030a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.coolots.sso.a.f */
/* loaded from: classes.dex */
class C0421f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0416a f1010a;

    private C0421f(C0416a c0416a) {
        this.f1010a = c0416a;
    }

    /* synthetic */ C0421f(C0416a c0416a, C0421f c0421f) {
        this(c0416a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        C0416a.m1476b("ChatONVAPIIReceiver() action: " + action);
        C0416a.m1476b("ChatONVAPIIReceiver() this: " + this);
        if (this.f1010a.f1004c != null) {
            C0416a.m1476b("ChatONVAPIIReceiver() mListener: " + this.f1010a.f1004c);
        }
        if (this.f1010a.f1003b != null) {
            C0416a.m1476b("ChatONVAPIIReceiver() mReceiver: " + this.f1010a.f1003b);
        }
        if (!action.equals("com.coolots.chaton.account.ACCOUNT_RESULTINFO")) {
            if (action.equals("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO") && intent.hasExtra("result")) {
                C0416a.m1476b("BR_REMOVE_ACCOUNT_RESULT_INFO");
                if (this.f1010a.f1004c != null) {
                    this.f1010a.f1004c.mo1509a_(intent.getBooleanExtra("result", false));
                    return;
                }
                return;
            }
            return;
        }
        if (intent.hasExtra("result")) {
            C0416a.m1476b("BR_ACCOUNT_RESULT_INFO");
            if (this.f1010a.f1004c != null) {
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                String stringExtra = intent.getStringExtra("account_fail_string");
                C0416a.m1476b("result: " + booleanExtra + ", result string: " + stringExtra);
                this.f1010a.f1004c.mo1508a(booleanExtra, stringExtra);
            }
        }
    }
}
