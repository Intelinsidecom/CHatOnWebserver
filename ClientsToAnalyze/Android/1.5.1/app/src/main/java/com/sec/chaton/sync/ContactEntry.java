package com.sec.chaton.sync;

import com.sec.chaton.p000io.entry.Entry;

/* loaded from: classes.dex */
public class ContactEntry extends Entry {

    /* renamed from: a */
    private int f3308a;

    /* renamed from: b */
    private String f3309b;

    /* renamed from: c */
    private int f3310c;

    /* renamed from: d */
    private String f3311d;

    public ContactEntry(int i, String str, int i2, String str2) {
        this.f3308a = i;
        this.f3309b = str;
        this.f3310c = i2;
        this.f3311d = str2;
    }

    /* renamed from: a */
    public String m3295a() {
        return this.f3309b;
    }

    /* renamed from: b */
    public int m3296b() {
        return this.f3310c;
    }

    /* renamed from: c */
    public String m3297c() {
        return this.f3311d;
    }
}
