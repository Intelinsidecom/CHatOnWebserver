package com.sec.chaton.facebook;

import android.os.Bundle;
import com.sec.chaton.R;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.r */
/* loaded from: classes.dex */
class C0737r extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2728a;

    /* renamed from: e */
    private String f2729e;

    /* renamed from: f */
    private String f2730f;

    /* synthetic */ C0737r(C0725f c0725f, String str, String str2, HandlerC0726g handlerC0726g) {
        this(c0725f, str, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0737r(C0725f c0725f, String str, String str2) {
        super(c0725f, "PostInviteTask");
        this.f2728a = c0725f;
        this.f2729e = str;
        this.f2730f = str2;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        Bundle bundle = new Bundle();
        if (this.f2730f != null && this.f2730f.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0) {
            bundle.putString("message", this.f2730f);
        } else {
            bundle.putString("message", this.f2728a.f2703c.getString(R.string.facebook_login_auto_post_text));
        }
        bundle.putString("picture", this.f2728a.f2703c.getString(R.string.logo_url_for_facebook));
        bundle.putString("link", "www.chaton.com/invite.html");
        bundle.putString("name", "ChatON");
        bundle.putString("caption", "www.chaton.com/invite.html<center></center>&nbsp;<center></center>" + this.f2728a.f2703c.getString(R.string.logo_is_different_for_canada));
        return m3229a(this.f2729e + "/feed", bundle, "POST", "id");
    }
}
