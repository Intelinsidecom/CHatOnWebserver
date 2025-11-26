package com.sec.chaton.p057e.p058a;

import android.text.TextUtils;

/* compiled from: ContactDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.g */
/* loaded from: classes.dex */
public class C2193g {

    /* renamed from: a */
    String f7830a;

    /* renamed from: b */
    String f7831b;

    /* renamed from: c */
    String f7832c;

    /* renamed from: d */
    String f7833d;

    C2193g(String str, String str2, String str3, String str4) {
        this.f7830a = "";
        this.f7831b = "";
        this.f7832c = "";
        this.f7833d = "";
        this.f7830a = str;
        this.f7831b = str2;
        this.f7832c = str3;
        this.f7833d = str4;
    }

    /* renamed from: a */
    public String m9886a() {
        return this.f7830a;
    }

    /* renamed from: b */
    public String m9887b() {
        return this.f7831b;
    }

    /* renamed from: c */
    public boolean m9888c() {
        return !TextUtils.isEmpty(this.f7831b) && this.f7831b.length() >= 8;
    }

    /* renamed from: d */
    public String m9889d() {
        if (TextUtils.isEmpty(this.f7831b)) {
            return null;
        }
        return this.f7831b.replaceAll("[^\\+\\*\\#0-9]", "");
    }
}
