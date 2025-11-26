package com.renren.android;

import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;

/* compiled from: Renren.java */
/* renamed from: com.renren.android.c */
/* loaded from: classes.dex */
class C0202c implements InterfaceC2786b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2786b f413a;

    /* renamed from: b */
    final /* synthetic */ Renren f414b;

    C0202c(Renren renren, InterfaceC2786b interfaceC2786b) {
        this.f414b = renren;
        this.f413a = interfaceC2786b;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo540a(C2785a c2785a) {
        Log.e("Renren-SDK", "failed to login by error : " + c2785a.getMessage());
        this.f413a.mo540a(c2785a);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo541a(Object obj) {
        String str;
        CookieSyncManager.getInstance().sync();
        if ((obj instanceof String) && (str = (String) obj) != null) {
            Log.d("Renren-SDK", "Success obtain access_token=" + str);
            try {
                this.f414b.m525a(str);
                this.f413a.mo541a(obj);
            } catch (Exception e) {
                e.printStackTrace();
                this.f413a.mo540a(new C2785a(e.getMessage(), -1007, e.toString()));
            }
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo539a() {
        Log.d("Renren-SDK", "Login canceled");
        this.f413a.mo539a();
    }
}
