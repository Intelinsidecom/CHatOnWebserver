package com.sec.chaton.facebook;

import android.os.Bundle;
import com.sec.chaton.R;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.h */
/* loaded from: classes.dex */
class C0727h extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2707a;

    /* synthetic */ C0727h(C0725f c0725f, HandlerC0726g handlerC0726g) {
        this(c0725f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0727h(C0725f c0725f) {
        super(c0725f, "AutoPostAfterLogin");
        this.f2707a = c0725f;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "fql.query");
        bundle.putString("query", "SELECT post_id FROM stream WHERE source_id = me() AND app_id=254066384616989");
        int iA = m3229a(null, bundle, "GET", null);
        if (iA != -1 || "[]".equals(this.f2710c)) {
            C0725f.m3213c("Auto post after login");
            Bundle bundle2 = new Bundle();
            bundle2.putString("message", this.f2707a.f2703c.getString(R.string.facebook_login_auto_post_text));
            bundle2.putString("picture", this.f2707a.f2703c.getString(R.string.logo_url_for_facebook));
            bundle2.putString("link", "www.chaton.com/invite.html");
            bundle2.putString("name", "ChatON");
            bundle2.putString("caption", "www.chaton.com/invite.html<center></center>&nbsp;<center></center>" + this.f2707a.f2703c.getString(R.string.logo_is_different_for_canada));
            return m3229a("me/feed", bundle2, "POST", "id");
        }
        this.f2710c = null;
        return iA;
    }
}
