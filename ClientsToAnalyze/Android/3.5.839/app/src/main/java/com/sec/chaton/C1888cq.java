package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cq */
/* loaded from: classes.dex */
class C1888cq extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7105a;

    C1888cq(SplashActivity splashActivity) {
        this.f7105a = splashActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f7105a.f2013n.m18261a();
        if (this.f7105a.f2016r && !this.f7105a.f2017s) {
            this.f7105a.f2017s = true;
            this.f7105a.unregisterReceiver(this.f7105a.f2012F);
        }
        boolean booleanExtra = intent.getBooleanExtra("validation_result", false);
        C4809aa.m18104a().m18125b("chaton_sa_is_valid", Boolean.valueOf(booleanExtra));
        if (C4904y.f17872b) {
            C4904y.m18639b("validation : " + booleanExtra, SplashActivity.f2006p);
        }
        this.f7105a.m2990l();
    }
}
