package com.sec.chaton.settings;

import android.content.Intent;
import android.support.v4.content.C0096i;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.sec.chaton.ChatONVUpgradeDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.h */
/* loaded from: classes.dex */
class C3660h implements InterfaceC0419d {

    /* renamed from: a */
    final /* synthetic */ C3644g f13236a;

    C3660h(C3644g c3644g) {
        this.f13236a = c3644g;
    }

    @Override // com.coolots.sso.p030a.InterfaceC0419d
    /* renamed from: a */
    public void mo1510a(String str, String str2, int i) {
        C4904y.m18639b("[onReceiveUpdateVerion] ChatONV currentVersionName : " + str + ",serverVersionName : " + str2 + ",versionInfo : " + i, AboutServiceFragment.f12441o);
        this.f13236a.f13204a.f12442a[AboutServiceFragment.f12439d] = str;
        this.f13236a.f13204a.f12443b[AboutServiceFragment.f12439d] = str2;
        C4809aa.m18108a("chatonv_update_version", str2);
        if (i != 0) {
            this.f13236a.f13204a.f12456r = true;
            this.f13236a.notifyDataSetChanged();
            C4809aa.m18106a("chatonVUpdateStatus", Integer.valueOf(i));
            C0096i.m358a(GlobalApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
            if (i == 3) {
                C4809aa.m18105a("chatonv_critical_update", (Boolean) true);
                Intent intent = new Intent(this.f13236a.f13204a.f12452m, (Class<?>) ChatONVUpgradeDialog.class);
                intent.putExtra("isCritical", true);
                intent.putExtra("isFromHome", true);
                this.f13236a.f13204a.startActivity(intent);
            }
        }
    }
}
