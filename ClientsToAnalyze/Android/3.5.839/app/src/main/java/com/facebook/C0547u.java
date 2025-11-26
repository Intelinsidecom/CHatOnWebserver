package com.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.p032b.C0476s;
import com.facebook.p033c.DialogC0518o;
import com.p137vk.sdk.VKOpenAuthActivity;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.u */
/* loaded from: classes.dex */
class C0547u extends AbstractC0535i {

    /* renamed from: b */
    final /* synthetic */ C0502c f1365b;

    /* renamed from: c */
    private transient DialogC0518o f1366c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0547u(C0502c c0502c) {
        super(c0502c);
        this.f1365b = c0502c;
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: a */
    boolean mo1918a() {
        return true;
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: b */
    boolean mo1920b() {
        return true;
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: c */
    void mo1921c() {
        if (this.f1366c != null) {
            this.f1366c.dismiss();
            this.f1366c = null;
        }
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: a */
    boolean mo1919a(C0536j c0536j) {
        String strM1928f = c0536j.m1928f();
        Bundle bundle = new Bundle();
        if (!C0476s.m1718a(c0536j.m1924b())) {
            bundle.putString(VKOpenAuthActivity.VK_EXTRA_SCOPE, TextUtils.join(",", c0536j.m1924b()));
        }
        C0476s.m1711a(this.f1365b.f1252c);
        this.f1366c = new C0534h(this.f1365b.m1845f().mo1788a(), strM1928f, bundle).m1902a(new C0548v(this, c0536j)).mo1900a();
        this.f1366c.show();
        return true;
    }

    /* renamed from: a */
    void m1939a(C0536j c0536j, Bundle bundle, C0551y c0551y) {
        C0544r c0544rM1938a;
        if (bundle != null) {
            CookieSyncManager.createInstance(this.f1365b.f1252c).sync();
            c0544rM1938a = C0544r.m1936a(C0424a.m1527a(c0536j.m1924b(), bundle, EnumC0457b.WEB_VIEW));
        } else if (c0551y instanceof C0431aa) {
            c0544rM1938a = C0544r.m1937a("User canceled log in.");
        } else {
            c0544rM1938a = C0544r.m1938a(c0551y.getMessage(), null);
        }
        this.f1365b.m1834a(c0544rM1938a);
    }
}
