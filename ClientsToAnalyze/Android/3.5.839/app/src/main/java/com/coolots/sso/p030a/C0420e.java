package com.coolots.sso.p030a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.coolots.sso.a.e */
/* loaded from: classes.dex */
class C0420e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0416a f1009a;

    private C0420e(C0416a c0416a) {
        this.f1009a = c0416a;
    }

    /* synthetic */ C0420e(C0416a c0416a, C0420e c0420e) {
        this(c0416a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        C0416a.m1476b("ChatONVAPIICallReceiver() action: " + action);
        C0416a.m1476b("ChatONVAPIICallReceiver() this: " + this);
        if (this.f1009a.f1006e != null) {
            C0416a.m1476b("ChatONVAPIICallReceiver() mCallListener: " + this.f1009a.f1006e);
        }
        if (this.f1009a.f1005d != null) {
            C0416a.m1476b("ChatONVAPIICallReceiver() mCallReceiver: " + this.f1009a.f1005d);
        }
        if (!action.equals("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO")) {
            if (action.equals("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED")) {
                C0416a.m1476b("BR_CONFERENCE_MEMBER_CHANGED");
                if (this.f1009a.f1006e != null) {
                    this.f1009a.f1006e.mo1506a();
                    return;
                }
                return;
            }
            return;
        }
        if (intent.hasExtra("result")) {
            int intExtra = intent.getIntExtra("result", 3);
            C0416a.m1476b("BR_CALL_STATE_CHANGE_INFO state(" + C0416a.m1468a(intExtra) + ")");
            if (this.f1009a.f1006e != null) {
                this.f1009a.f1006e.mo1507a(intExtra);
            }
        }
    }
}
