package com.sec.vip.amschaton.p071a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: AMSDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.a */
/* loaded from: classes.dex */
public class C3393a {

    /* renamed from: a */
    protected final Context f12430a;

    /* renamed from: b */
    protected C3394b f12431b;

    /* renamed from: c */
    protected SQLiteDatabase f12432c;

    public C3393a(Context context) {
        this.f12430a = context;
    }

    /* renamed from: a */
    public C3393a m12097a(String str) {
        this.f12431b = new C3394b(this.f12430a, str);
        this.f12432c = this.f12431b.getWritableDatabase();
        return this;
    }

    /* renamed from: a */
    public void mo12098a() {
        if (this.f12431b != null) {
            this.f12431b.close();
            this.f12431b = null;
        }
        if (this.f12432c != null) {
            this.f12432c.close();
            this.f12432c = null;
        }
    }
}
