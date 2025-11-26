package com.sec.chaton.smsplugin.provider;

import android.database.Cursor;

/* compiled from: FullSyncTask.java */
/* renamed from: com.sec.chaton.smsplugin.provider.j */
/* loaded from: classes.dex */
class C3952j {

    /* renamed from: a */
    public String f14233a;

    /* renamed from: b */
    public long f14234b;

    /* renamed from: c */
    public String f14235c;

    /* renamed from: d */
    public String f14236d;

    /* renamed from: e */
    public int f14237e;

    /* renamed from: f */
    public int f14238f;

    /* renamed from: g */
    public String f14239g;

    /* renamed from: h */
    public int f14240h;

    protected C3952j(Cursor cursor) {
        this.f14233a = null;
        this.f14234b = 0L;
        this.f14235c = null;
        this.f14236d = null;
        this.f14237e = 0;
        this.f14238f = 0;
        this.f14239g = null;
        this.f14240h = 0;
        this.f14233a = cursor.getString(0);
        this.f14234b = cursor.getLong(1);
        this.f14239g = cursor.getString(2);
        this.f14236d = cursor.getString(3);
        this.f14237e = cursor.getInt(4);
        this.f14238f = cursor.getInt(5);
        this.f14235c = cursor.getString(6);
        this.f14240h = cursor.getInt(7);
    }
}
