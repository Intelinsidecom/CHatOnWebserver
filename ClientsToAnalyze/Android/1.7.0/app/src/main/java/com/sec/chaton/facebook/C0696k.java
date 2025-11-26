package com.sec.chaton.facebook;

import android.os.Bundle;
import com.sec.chaton.R;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.k */
/* loaded from: classes.dex */
class C0696k extends AbstractC0701p {

    /* renamed from: a */
    final /* synthetic */ C0700o f2370a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0696k(C0700o c0700o) {
        super(c0700o, "AutoPostAfterLogin");
        this.f2370a = c0700o;
    }

    @Override // com.sec.chaton.facebook.AbstractC0701p
    /* renamed from: a */
    protected int mo3065a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "fql.query");
        bundle.putString("query", "SELECT post_id FROM stream WHERE source_id = me() AND app_id=254066384616989");
        int iA = m3088a(null, bundle, "GET", null);
        if (iA != -1 || "[]".equals(this.f2380c)) {
            C0700o.m3078c("Auto post after login");
            Bundle bundle2 = new Bundle();
            bundle2.putString("message", this.f2370a.f2376b.getString(R.string.facebook_login_auto_post_text));
            bundle2.putString("picture", this.f2370a.f2376b.getString(R.string.logo_url_for_facebook));
            bundle2.putString("link", "www.chaton.com");
            bundle2.putString("name", "ChatON");
            bundle2.putString("caption", "www.chaton.com<center></center>&nbsp;<center></center>" + this.f2370a.f2376b.getString(R.string.logo_is_different_for_canada));
            return m3088a("me/feed", bundle2, "POST", "id");
        }
        this.f2380c = null;
        return iA;
    }
}
