package com.p001a.p002a;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;

/* compiled from: Facebook.java */
/* renamed from: com.a.a.g */
/* loaded from: classes.dex */
class C0042g implements InterfaceC0041f {

    /* renamed from: a */
    final /* synthetic */ C0043h f3a;

    C0042g(C0043h c0043h) {
        this.f3a = c0043h;
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo16a(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.f3a.m31a(bundle.getString("access_token"));
        this.f3a.m34b(bundle.getString("expires_in"));
        if (!this.f3a.m32a()) {
            this.f3a.f13j.mo18a(new C0047l("Failed to receive access token."));
        } else {
            Log.d("Facebook-authorize", "Login Success! access_token=" + this.f3a.m33b() + " expires=" + this.f3a.m35c());
            this.f3a.f13j.mo16a(bundle);
        }
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo17a(C0046k c0046k) {
        Log.d("Facebook-authorize", "Login failed: " + c0046k);
        this.f3a.f13j.mo17a(c0046k);
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo18a(C0047l c0047l) {
        Log.d("Facebook-authorize", "Login failed: " + c0047l);
        this.f3a.f13j.mo18a(c0047l);
    }

    @Override // com.p001a.p002a.InterfaceC0041f
    /* renamed from: a */
    public void mo15a() {
        Log.d("Facebook-authorize", "Login canceled");
        this.f3a.f13j.mo15a();
    }
}
