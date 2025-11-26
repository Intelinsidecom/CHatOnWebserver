package com.sec.chaton;

import android.content.pm.PackageManager;
import android.os.Bundle;
import com.sec.chaton.registration.InterfaceC3162bd;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cl */
/* loaded from: classes.dex */
class C1883cl implements InterfaceC3162bd {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7100a;

    C1883cl(SplashActivity splashActivity) {
        this.f7100a = splashActivity;
    }

    @Override // com.sec.chaton.registration.InterfaceC3162bd
    /* renamed from: a */
    public void mo9076a(boolean z, Bundle bundle, boolean z2) throws PackageManager.NameNotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("[FirstLauncher result] success : " + z + " skip : " + z2, SplashActivity.f2006p);
        }
        this.f7100a.f2020v = z2;
        if (z) {
            if (!this.f7100a.m2988j()) {
                this.f7100a.m2992b(this.f7100a.m2988j());
                return;
            } else if (C4809aa.m18104a().m18119a("need_to_update_gld_feature", (Boolean) false).booleanValue()) {
                C4809aa.m18104a().m18125b("need_to_update_gld_feature", (Boolean) false);
                this.f7100a.f2007A.m9557c();
                return;
            } else {
                this.f7100a.m2992b(true);
                return;
            }
        }
        this.f7100a.finish();
    }
}
