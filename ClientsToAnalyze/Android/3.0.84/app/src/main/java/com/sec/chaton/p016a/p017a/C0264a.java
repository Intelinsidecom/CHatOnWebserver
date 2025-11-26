package com.sec.chaton.p016a.p017a;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyEntry.java */
/* renamed from: com.sec.chaton.a.a.a */
/* loaded from: classes.dex */
public class C0264a {

    /* renamed from: a */
    private String f808a;

    /* renamed from: b */
    private String f809b;

    /* renamed from: c */
    private String f810c;

    public C0264a(String str) {
        this.f808a = str;
        this.f809b = GlobalApplication.m6451b().getString(R.string.unknown);
    }

    public C0264a(String str, String str2, String str3) {
        this.f808a = str;
        this.f809b = str2;
        this.f810c = str3;
    }

    /* renamed from: a */
    public void m1330a(String str) {
        this.f808a = str;
    }

    /* renamed from: b */
    public void m1331b(String str) {
        this.f809b = str;
    }

    /* renamed from: c */
    public void m1332c(String str) {
        this.f810c = str;
    }

    /* renamed from: a */
    public String m1329a() {
        return this.f809b;
    }
}
