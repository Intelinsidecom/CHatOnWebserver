package com.sec.chaton;

import android.content.Intent;
import android.support.v4.content.C0096i;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.eb */
/* loaded from: classes.dex */
class C2308eb implements InterfaceC0419d {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8231a;

    C2308eb(TabActivity tabActivity) {
        this.f8231a = tabActivity;
    }

    @Override // com.coolots.sso.p030a.InterfaceC0419d
    /* renamed from: a */
    public void mo1510a(String str, String str2, int i) {
        C4904y.m18639b("[onReceiveUpdateVerion] currentVersionName : " + str + ",serverVersionName : " + str2 + ",versionInfo : " + i, TabActivity.f2029t);
        C4809aa.m18106a("chatonVUpdateStatus", Integer.valueOf(i));
        C4809aa.m18108a("chatonv_update_version", str2);
        if (i != 0) {
            C0096i.m358a(GlobalApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
            switch (i) {
                case 1:
                case 2:
                    if (!this.f8231a.m3004H()) {
                        if (!this.f8231a.f2044M) {
                            this.f8231a.m3031b(false);
                            break;
                        }
                    } else {
                        this.f8231a.f2047P = true;
                        break;
                    }
                    break;
                case 3:
                    if (!this.f8231a.m3004H()) {
                        if (!this.f8231a.f2044M) {
                            this.f8231a.m3031b(true);
                        }
                    } else {
                        this.f8231a.f2047P = true;
                    }
                    C4809aa.m18105a("chatonv_critical_update", (Boolean) true);
                    break;
            }
        }
        C4859bx.m18400d(this.f8231a);
    }
}
