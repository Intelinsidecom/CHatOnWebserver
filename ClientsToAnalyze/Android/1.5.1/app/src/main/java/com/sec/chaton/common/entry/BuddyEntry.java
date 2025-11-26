package com.sec.chaton.common.entry;

/* loaded from: classes.dex */
public class BuddyEntry {

    /* renamed from: a */
    private String f1300a;

    /* renamed from: b */
    private String f1301b;

    /* renamed from: c */
    private String f1302c;

    public BuddyEntry(String str) {
        this.f1300a = str;
    }

    public BuddyEntry(String str, String str2, String str3) {
        this.f1300a = str;
        this.f1301b = str2;
        this.f1302c = str3;
    }

    /* renamed from: a */
    public String m1942a() {
        return this.f1301b;
    }

    /* renamed from: a */
    public void m1943a(String str) {
        this.f1301b = str;
    }

    /* renamed from: b */
    public void m1944b(String str) {
        this.f1302c = str;
    }
}
