package com.sec.chaton.smsplugin.spam;

import android.database.Cursor;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.l */
/* loaded from: classes.dex */
class C4034l {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14541a;

    /* renamed from: b */
    private final long f14542b;

    /* renamed from: c */
    private final String f14543c;

    /* renamed from: d */
    private String f14544d;

    /* renamed from: e */
    private String f14545e;

    /* renamed from: f */
    private long f14546f;

    /* renamed from: g */
    private String f14547g;

    public C4034l(ManageSpamMessages manageSpamMessages, long j, String str) {
        this.f14541a = manageSpamMessages;
        this.f14544d = null;
        this.f14545e = null;
        this.f14546f = 0L;
        this.f14547g = null;
        this.f14542b = j;
        this.f14543c = str;
    }

    public C4034l(ManageSpamMessages manageSpamMessages, long j, String str, Cursor cursor) {
        this.f14541a = manageSpamMessages;
        this.f14544d = null;
        this.f14545e = null;
        this.f14546f = 0L;
        this.f14547g = null;
        this.f14542b = j;
        this.f14543c = str;
        this.f14544d = cursor.getString(cursor.getColumnIndexOrThrow("address"));
        this.f14545e = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        this.f14546f = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
        this.f14547g = cursor.getString(cursor.getColumnIndexOrThrow("transport_type"));
    }

    /* renamed from: a */
    public long m15504a() {
        return this.f14542b;
    }

    /* renamed from: b */
    public String m15505b() {
        return this.f14543c;
    }

    /* renamed from: c */
    public String m15506c() {
        return this.f14544d;
    }

    /* renamed from: d */
    public String m15507d() {
        return this.f14545e;
    }

    /* renamed from: e */
    public long m15508e() {
        return this.f14546f;
    }

    /* renamed from: f */
    public String m15509f() {
        return this.f14547g;
    }
}
