package com.renren.android;

import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;

/* compiled from: Renren.java */
/* renamed from: com.renren.android.c */
/* loaded from: classes.dex */
class C0714c implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4366c f1649a;

    /* renamed from: b */
    final /* synthetic */ Renren f1650b;

    C0714c(Renren renren, InterfaceC4366c interfaceC4366c) {
        this.f1650b = renren;
        this.f1649a = interfaceC4366c;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        Log.e("Renren-SDK", "failed to login by error : " + c4365b.getMessage());
        this.f1649a.mo2272a(c4365b);
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        String str;
        CookieSyncManager.getInstance().sync();
        if ((obj instanceof String) && (str = (String) obj) != null) {
            Log.d("Renren-SDK", "Success obtain access_token=" + str);
            try {
                this.f1650b.m2257a(str);
                this.f1649a.mo2273a(obj);
            } catch (Exception e) {
                e.printStackTrace();
                this.f1649a.mo2272a(new C4365b(e.getMessage(), -1007, e.toString()));
            }
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        Log.d("Renren-SDK", "Login canceled");
        this.f1649a.mo2271a();
    }
}
