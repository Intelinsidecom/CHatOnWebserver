package com.sec.chaton.settings;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.h */
/* loaded from: classes.dex */
class C2704h implements InterfaceC0048d {

    /* renamed from: a */
    final /* synthetic */ C2703g f10010a;

    C2704h(C2703g c2703g) {
        this.f10010a = c2703g;
    }

    @Override // com.coolots.sso.p006a.InterfaceC0048d
    public void onReceiveUpdateVerion(String str, String str2, int i) {
        C3250y.m11450b("[onReceiveUpdateVerion] ChatONV currentVersionName : " + str + ",serverVersionName : " + str2 + ",versionInfo : " + i, AboutServiceFragment.f8911o);
        this.f10010a.f10001a.f8912a[AboutServiceFragment.f8909d] = str;
        this.f10010a.f10001a.f8913b[AboutServiceFragment.f8909d] = str2;
        C3159aa.m10966a("chatonv_update_version", str2);
        if (i != 0) {
            this.f10010a.f10001a.f8926r = true;
            this.f10010a.notifyDataSetChanged();
            C3159aa.m10964a("chatonVUpdateStatus", Integer.valueOf(i));
            if (i != 0) {
                LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
            }
        }
    }
}
