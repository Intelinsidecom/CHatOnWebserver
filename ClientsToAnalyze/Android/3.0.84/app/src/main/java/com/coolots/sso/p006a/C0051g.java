package com.coolots.sso.p006a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.spp.push.Config;

/* renamed from: com.coolots.sso.a.g */
/* loaded from: classes.dex */
class C0051g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0045a f42a;

    private C0051g(C0045a c0045a) {
        this.f42a = c0045a;
    }

    /* synthetic */ C0051g(C0045a c0045a, C0051g c0051g) {
        this(c0045a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        C0045a.m36b("ChatONVAPIIUpdateReceiver() action: " + action);
        C0045a.m36b("ChatONVAPIIUpdateReceiver() this: " + toString());
        C0045a.m36b("ChatONVAPIIUpdateReceiver() mUpdateListener: " + this.f42a.f39g.toString());
        C0045a.m36b("ChatONVAPIIUpdateReceiver() mUpdateReceiver: " + this.f42a.f38f.toString());
        if (action.equals("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO") && intent.hasExtra("version_name") && intent.hasExtra(Config.PROVIDER_PATH_VERSION_INFO)) {
            String stringExtra = intent.getStringExtra("current_version_name");
            String stringExtra2 = intent.getStringExtra("version_name");
            int intExtra = intent.getIntExtra(Config.PROVIDER_PATH_VERSION_INFO, 0);
            C0045a.m36b("BR_UPGRADE_NEW_APK_INFO " + stringExtra + ", " + stringExtra2 + ", " + intExtra);
            if (this.f42a.f39g != null) {
                this.f42a.f39g.onReceiveUpdateVerion(stringExtra, stringExtra2, intExtra);
            }
        }
    }
}
