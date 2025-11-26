package com.coolots.sso.p006a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.coolots.sso.a.e */
/* loaded from: classes.dex */
class C0049e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0045a f40a;

    private C0049e(C0045a c0045a) {
        this.f40a = c0045a;
    }

    /* synthetic */ C0049e(C0045a c0045a, C0049e c0049e) {
        this(c0045a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        C0045a.m36b("ChatONVAPIICallReceiver() action: " + action);
        C0045a.m36b("ChatONVAPIICallReceiver() this: " + toString());
        C0045a.m36b("ChatONVAPIICallReceiver() mCallListener: " + this.f40a.f37e.toString());
        C0045a.m36b("ChatONVAPIICallReceiver() mCallReceiver: " + this.f40a.f36d.toString());
        if (!action.equals("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO")) {
            if (action.equals("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED")) {
                C0045a.m36b("BR_CONFERENCE_MEMBER_CHANGED");
                if (this.f40a.f37e != null) {
                    this.f40a.f37e.mo66a();
                    return;
                }
                return;
            }
            return;
        }
        if (intent.hasExtra("result")) {
            int intExtra = intent.getIntExtra("result", 3);
            C0045a.m36b("BR_CALL_STATE_CHANGE_INFO state(" + C0045a.m28a(intExtra) + ")");
            if (this.f40a.f37e != null) {
                this.f40a.f37e.mo67a(intExtra);
            }
        }
    }
}
