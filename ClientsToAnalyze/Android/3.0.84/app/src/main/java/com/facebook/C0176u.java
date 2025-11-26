package com.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.p008b.C0105s;
import com.facebook.p009c.DialogC0147o;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.u */
/* loaded from: classes.dex */
class C0176u extends AbstractC0164i {

    /* renamed from: b */
    final /* synthetic */ C0131c f395b;

    /* renamed from: c */
    private transient DialogC0147o f396c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0176u(C0131c c0131c) {
        super(c0131c);
        this.f395b = c0131c;
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: a */
    boolean mo475a() {
        return true;
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: b */
    boolean mo477b() {
        return true;
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: c */
    void mo478c() {
        if (this.f396c != null) {
            this.f396c.dismiss();
            this.f396c = null;
        }
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: a */
    boolean mo476a(C0165j c0165j) {
        String strM485f = c0165j.m485f();
        Bundle bundle = new Bundle();
        if (!C0105s.m274a(c0165j.m481b())) {
            bundle.putString("scope", TextUtils.join(",", c0165j.m481b()));
        }
        C0105s.m267a(this.f395b.f283c);
        this.f396c = new C0163h(this.f395b.m402f().mo345a(), strM485f, bundle).m459a(new C0177v(this, c0165j)).mo457a();
        this.f396c.show();
        return true;
    }

    /* renamed from: a */
    void m496a(C0165j c0165j, Bundle bundle, C0180y c0180y) {
        C0173r c0173rM495a;
        if (bundle != null) {
            CookieSyncManager.createInstance(this.f395b.f283c).sync();
            c0173rM495a = C0173r.m493a(C0053a.m84a(c0165j.m481b(), bundle, EnumC0086b.WEB_VIEW));
        } else if (c0180y instanceof C0060aa) {
            c0173rM495a = C0173r.m494a("User canceled log in.");
        } else {
            c0173rM495a = C0173r.m495a(c0180y.getMessage(), null);
        }
        this.f395b.m391a(c0173rM495a);
    }
}
