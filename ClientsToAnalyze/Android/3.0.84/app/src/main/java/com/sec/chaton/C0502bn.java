package com.sec.chaton;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bn */
/* loaded from: classes.dex */
class C0502bn implements InterfaceC0048d {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1640a;

    C0502bn(TabActivity tabActivity) {
        this.f1640a = tabActivity;
    }

    @Override // com.coolots.sso.p006a.InterfaceC0048d
    public void onReceiveUpdateVerion(String str, String str2, int i) {
        C3250y.m11450b("[onReceiveUpdateVerion] currentVersionName : " + str + ",serverVersionName : " + str2 + ",versionInfo : " + i, TabActivity.f732f);
        C3159aa.m10964a("chatonVUpdateStatus", Integer.valueOf(i));
        C3159aa.m10966a("chatonv_update_version", str2);
        if (i != 0) {
            LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
            switch (i) {
                case 1:
                case 2:
                    if (!this.f1640a.m1201D()) {
                        this.f1640a.m1251b(false);
                        break;
                    } else {
                        this.f1640a.f746M = true;
                        break;
                    }
                case 3:
                    if (!this.f1640a.m1201D()) {
                        this.f1640a.m1251b(true);
                    } else {
                        this.f1640a.f746M = true;
                    }
                    C3159aa.m10963a("chatonv_critical_update", (Boolean) true);
                    break;
            }
        }
        C3214cb.m11268d(this.f1640a);
    }
}
