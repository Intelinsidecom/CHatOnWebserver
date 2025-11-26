package com.facebook.p033c;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.facebook.C0478ba;
import com.facebook.C0551y;
import com.facebook.p032b.C0477t;
import com.facebook.p033c.C0523t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.t */
/* loaded from: classes.dex */
public class C0523t<CONCRETE extends C0523t<?>> {

    /* renamed from: a */
    private Context f1316a;

    /* renamed from: b */
    private C0478ba f1317b;

    /* renamed from: c */
    private String f1318c;

    /* renamed from: d */
    private String f1319d;

    /* renamed from: e */
    private int f1320e = R.style.Theme.Translucent.NoTitleBar;

    /* renamed from: f */
    private InterfaceC0526w f1321f;

    /* renamed from: g */
    private Bundle f1322g;

    protected C0523t(Context context, C0478ba c0478ba, String str, Bundle bundle) {
        C0477t.m1721a(c0478ba, "session");
        if (!c0478ba.m1762b()) {
            throw new C0551y("Attempted to use a Session that was not open.");
        }
        this.f1317b = c0478ba;
        m1901a(context, str, bundle);
    }

    protected C0523t(Context context, String str, String str2, Bundle bundle) {
        C0477t.m1722a(str, "applicationId");
        this.f1318c = str;
        m1901a(context, str2, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public CONCRETE m1902a(InterfaceC0526w interfaceC0526w) {
        this.f1321f = interfaceC0526w;
        return this;
    }

    /* renamed from: a */
    public DialogC0518o mo1900a() {
        if (this.f1317b != null && this.f1317b.m1762b()) {
            this.f1322g.putString("app_id", this.f1317b.m1764d());
            this.f1322g.putString("access_token", this.f1317b.m1765e());
        } else {
            this.f1322g.putString("app_id", this.f1318c);
        }
        if (!this.f1322g.containsKey("redirect_uri")) {
            this.f1322g.putString("redirect_uri", "fbconnect://success");
        }
        return new DialogC0518o(this.f1316a, this.f1319d, this.f1322g, this.f1320e, this.f1321f);
    }

    /* renamed from: b */
    protected String m1903b() {
        return this.f1318c;
    }

    /* renamed from: c */
    protected Context m1904c() {
        return this.f1316a;
    }

    /* renamed from: d */
    protected int m1905d() {
        return this.f1320e;
    }

    /* renamed from: e */
    protected Bundle m1906e() {
        return this.f1322g;
    }

    /* renamed from: f */
    protected InterfaceC0526w m1907f() {
        return this.f1321f;
    }

    /* renamed from: a */
    private void m1901a(Context context, String str, Bundle bundle) {
        this.f1316a = context;
        this.f1319d = str;
        if (bundle != null) {
            this.f1322g = bundle;
        } else {
            this.f1322g = new Bundle();
        }
    }
}
