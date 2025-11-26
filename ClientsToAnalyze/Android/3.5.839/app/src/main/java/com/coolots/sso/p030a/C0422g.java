package com.coolots.sso.p030a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.spp.push.Config;

/* renamed from: com.coolots.sso.a.g */
/* loaded from: classes.dex */
class C0422g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0416a f1011a;

    private C0422g(C0416a c0416a) {
        this.f1011a = c0416a;
    }

    /* synthetic */ C0422g(C0416a c0416a, C0422g c0422g) {
        this(c0416a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        C0416a.m1476b("ChatONVAPIIUpdateReceiver() action: " + action);
        C0416a.m1476b("ChatONVAPIIUpdateReceiver() this: " + this);
        if (this.f1011a.f1008g != null) {
            C0416a.m1476b("ChatONVAPIIUpdateReceiver() mUpdateListener: " + this.f1011a.f1008g);
        }
        if (this.f1011a.f1007f != null) {
            C0416a.m1476b("ChatONVAPIIUpdateReceiver() mUpdateReceiver: " + this.f1011a.f1007f);
        }
        if (action.equals("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO") && intent.hasExtra("version_name") && intent.hasExtra(Config.PROVIDER_PATH_VERSION_INFO)) {
            String stringExtra = intent.getStringExtra("current_version_name");
            String stringExtra2 = intent.getStringExtra("version_name");
            if (stringExtra == null || stringExtra.isEmpty()) {
                stringExtra = "0.0";
            }
            if (stringExtra2 == null || stringExtra2.isEmpty()) {
                stringExtra2 = "0.0";
            }
            int intExtra = intent.getIntExtra(Config.PROVIDER_PATH_VERSION_INFO, 0);
            C0416a.m1476b("BR_UPGRADE_NEW_APK_INFO " + stringExtra + ", " + stringExtra2 + ", " + intExtra);
            if (this.f1011a.f1008g != null) {
                this.f1011a.f1008g.mo1510a(stringExtra, stringExtra2, intExtra);
            }
        }
    }
}
