package com.facebook.android;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.facebook.android.Facebook;

/* renamed from: com.facebook.android.d */
/* loaded from: classes.dex */
class C0051d implements Facebook.DialogListener {

    /* renamed from: a */
    final /* synthetic */ Facebook f216a;

    C0051d(Facebook facebook) {
        this.f216a = facebook;
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo244a() {
        Log.d("Facebook-authorize", "Login canceled");
        this.f216a.f201j.mo244a();
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo245a(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.f216a.m239a(bundle.getString("access_token"));
        this.f216a.m242b(bundle.getString("expires_in"));
        if (!this.f216a.m240a()) {
            this.f216a.f201j.mo247a(new FacebookError("Failed to receive access token."));
        } else {
            Log.d("Facebook-authorize", "Login Success! access_token=" + this.f216a.m241b() + " expires=" + this.f216a.m243c());
            this.f216a.f201j.mo245a(bundle);
        }
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo246a(DialogError dialogError) {
        Log.d("Facebook-authorize", "Login failed: " + dialogError);
        this.f216a.f201j.mo246a(dialogError);
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo247a(FacebookError facebookError) {
        Log.d("Facebook-authorize", "Login failed: " + facebookError);
        this.f216a.f201j.mo247a(facebookError);
    }
}
