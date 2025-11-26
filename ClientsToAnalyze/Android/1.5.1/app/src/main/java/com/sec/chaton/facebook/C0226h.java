package com.sec.chaton.facebook;

import android.os.Bundle;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.SessionStore;

/* renamed from: com.sec.chaton.facebook.h */
/* loaded from: classes.dex */
class C0226h implements Facebook.DialogListener {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1857a;

    /* renamed from: b */
    private int f1858b;

    /* renamed from: c */
    private AbstractC0231m f1859c;

    private C0226h(FacebookManager facebookManager, int i, AbstractC0231m abstractC0231m) {
        this.f1857a = facebookManager;
        this.f1858b = i;
        this.f1859c = abstractC0231m;
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo244a() {
        FacebookManager.m2348c("Login Request:" + this.f1858b + " Canceled.");
        this.f1857a.f1838c.onResult(this.f1858b, 0, null);
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo245a(Bundle bundle) {
        C0227i c0227i = null;
        FacebookManager.m2348c("Login Request:" + this.f1858b + " Done.");
        SessionStore.m256a(FacebookManager.f1836a, this.f1857a.f1837b);
        AsyncTaskC0230l asyncTaskC0230l = new AsyncTaskC0230l(this.f1857a, this.f1858b);
        C0229k c0229k = new C0229k(this.f1857a);
        C0228j c0228j = new C0228j(this.f1857a);
        this.f1857a.f1838c.onReady(this.f1858b, true);
        if (this.f1859c == null) {
            asyncTaskC0230l.execute(c0229k, c0228j);
        } else {
            asyncTaskC0230l.execute(c0229k, c0228j, this.f1859c);
        }
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo246a(DialogError dialogError) {
        FacebookManager.m2349d("Login Request:" + this.f1858b + " Webview Error. " + dialogError.getMessage());
        this.f1857a.f1838c.onResult(this.f1858b, -1002, dialogError.getMessage());
    }

    @Override // com.facebook.android.Facebook.DialogListener
    /* renamed from: a */
    public void mo247a(FacebookError facebookError) {
        FacebookManager.m2349d("Login Request:" + this.f1858b + " Facebook Error. " + facebookError.getMessage());
        this.f1857a.f1838c.onResult(this.f1858b, -1001, facebookError.getMessage());
    }
}
