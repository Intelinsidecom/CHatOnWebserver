package com.facebook.p009c;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.facebook.C0107ba;
import com.facebook.C0180y;
import com.facebook.p008b.C0106t;
import com.facebook.p009c.C0152t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.t */
/* loaded from: classes.dex */
public class C0152t<CONCRETE extends C0152t<?>> {

    /* renamed from: a */
    private Context f346a;

    /* renamed from: b */
    private C0107ba f347b;

    /* renamed from: c */
    private String f348c;

    /* renamed from: d */
    private String f349d;

    /* renamed from: e */
    private int f350e = R.style.Theme.Translucent.NoTitleBar;

    /* renamed from: f */
    private InterfaceC0155w f351f;

    /* renamed from: g */
    private Bundle f352g;

    protected C0152t(Context context, C0107ba c0107ba, String str, Bundle bundle) {
        C0106t.m277a(c0107ba, "session");
        if (!c0107ba.m319b()) {
            throw new C0180y("Attempted to use a Session that was not open.");
        }
        this.f347b = c0107ba;
        m458a(context, str, bundle);
    }

    protected C0152t(Context context, String str, String str2, Bundle bundle) {
        C0106t.m278a(str, "applicationId");
        this.f348c = str;
        m458a(context, str2, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public CONCRETE m459a(InterfaceC0155w interfaceC0155w) {
        this.f351f = interfaceC0155w;
        return this;
    }

    /* renamed from: a */
    public DialogC0147o mo457a() {
        if (this.f347b != null && this.f347b.m319b()) {
            this.f352g.putString("app_id", this.f347b.m321d());
            this.f352g.putString("access_token", this.f347b.m322e());
        } else {
            this.f352g.putString("app_id", this.f348c);
        }
        if (!this.f352g.containsKey("redirect_uri")) {
            this.f352g.putString("redirect_uri", "fbconnect://success");
        }
        return new DialogC0147o(this.f346a, this.f349d, this.f352g, this.f350e, this.f351f);
    }

    /* renamed from: b */
    protected String m460b() {
        return this.f348c;
    }

    /* renamed from: c */
    protected Context m461c() {
        return this.f346a;
    }

    /* renamed from: d */
    protected int m462d() {
        return this.f350e;
    }

    /* renamed from: e */
    protected Bundle m463e() {
        return this.f352g;
    }

    /* renamed from: f */
    protected InterfaceC0155w m464f() {
        return this.f351f;
    }

    /* renamed from: a */
    private void m458a(Context context, String str, Bundle bundle) {
        this.f346a = context;
        this.f349d = str;
        if (bundle != null) {
            this.f352g = bundle;
        } else {
            this.f352g = new Bundle();
        }
    }
}
