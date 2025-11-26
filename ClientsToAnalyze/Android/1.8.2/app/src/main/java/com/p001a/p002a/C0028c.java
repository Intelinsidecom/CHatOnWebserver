package com.p001a.p002a;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;

/* compiled from: Facebook.java */
/* renamed from: com.a.a.c */
/* loaded from: classes.dex */
class C0028c implements InterfaceC0029d {

    /* renamed from: a */
    final /* synthetic */ C0027b f13a;

    C0028c(C0027b c0027b) {
        this.f13a = c0027b;
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo20a(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.f13a.m14a(bundle.getString("access_token"));
        this.f13a.m17b(bundle.getString("expires_in"));
        if (!this.f13a.m15a()) {
            this.f13a.f11j.mo22a(new C0030e("Failed to receive access token."));
        } else {
            Log.d("Facebook-authorize", "Login Success! access_token=" + this.f13a.m16b() + " expires=" + this.f13a.m18c());
            this.f13a.f11j.mo20a(bundle);
        }
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo21a(C0026a c0026a) {
        Log.d("Facebook-authorize", "Login failed: " + c0026a);
        this.f13a.f11j.mo21a(c0026a);
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo22a(C0030e c0030e) {
        Log.d("Facebook-authorize", "Login failed: " + c0030e);
        this.f13a.f11j.mo22a(c0030e);
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo19a() {
        Log.d("Facebook-authorize", "Login canceled");
        this.f13a.f11j.mo19a();
    }
}
