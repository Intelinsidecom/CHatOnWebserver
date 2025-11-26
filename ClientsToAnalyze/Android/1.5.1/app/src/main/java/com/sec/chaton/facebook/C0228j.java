package com.sec.chaton.facebook;

import android.os.Bundle;

/* renamed from: com.sec.chaton.facebook.j */
/* loaded from: classes.dex */
class C0228j extends AbstractC0231m {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1860a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0228j(FacebookManager facebookManager) {
        super(facebookManager, "AutoPostAfterLogin");
        this.f1860a = facebookManager;
    }

    @Override // com.sec.chaton.facebook.AbstractC0231m
    /* renamed from: a */
    protected int mo2365a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "fql.query");
        bundle.putString("query", "SELECT post_id FROM stream WHERE source_id = me() AND app_id=254066384616989");
        int iA = m2370a(null, bundle, "GET", null);
        if (iA == -1 && !this.f1867c.equals("[]")) {
            this.f1867c = null;
            return iA;
        }
        FacebookManager.m2348c("Auto post after login");
        Bundle bundle2 = new Bundle();
        bundle2.putString("message", "I'm using ChatON to keep in touch with my buddies. Let's enjoy various features that you've never seen before. See you on ChatON.");
        bundle2.putString("picture", "http://i0.chatoncdn.com/logo.png?rv=01");
        bundle2.putString("link", "http://www.chaton.com");
        bundle2.putString("name", "ChatON");
        bundle2.putString("caption", "chaton.com");
        return m2370a("me/feed", bundle2, "POST", "id");
    }
}
