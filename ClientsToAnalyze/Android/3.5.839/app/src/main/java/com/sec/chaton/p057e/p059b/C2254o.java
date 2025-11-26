package com.sec.chaton.p057e.p059b;

import android.text.TextUtils;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p065io.entry.PushEntry;

/* compiled from: PushReceivedTask.java */
/* renamed from: com.sec.chaton.e.b.o */
/* loaded from: classes.dex */
public class C2254o {

    /* renamed from: a */
    private boolean f8027a;

    /* renamed from: b */
    private PushEntry f8028b;

    /* renamed from: c */
    private String f8029c;

    /* renamed from: d */
    private String f8030d;

    /* renamed from: e */
    private int f8031e;

    /* renamed from: f */
    private int f8032f;

    /* renamed from: g */
    private EnumC2214ab f8033g;

    /* renamed from: h */
    private boolean f8034h;

    /* renamed from: i */
    private String f8035i;

    /* renamed from: j */
    private boolean f8036j;

    /* renamed from: k */
    private long f8037k;

    public C2254o(String str, boolean z, PushEntry pushEntry, String str2, int i, int i2, EnumC2214ab enumC2214ab, boolean z2, String str3, boolean z3, long j) {
        this.f8027a = z;
        this.f8028b = pushEntry;
        this.f8029c = str;
        this.f8030d = str2;
        this.f8031e = i;
        this.f8032f = i2;
        this.f8033g = enumC2214ab;
        this.f8034h = z2;
        this.f8035i = str3;
        this.f8036j = z3;
        this.f8037k = j;
    }

    /* renamed from: a */
    public String m10109a() {
        return this.f8029c;
    }

    /* renamed from: b */
    public boolean m10110b() {
        return this.f8027a;
    }

    /* renamed from: c */
    public PushEntry m10111c() {
        return this.f8028b;
    }

    /* renamed from: d */
    public String m10112d() {
        return this.f8030d;
    }

    /* renamed from: e */
    public int m10113e() {
        return this.f8032f;
    }

    /* renamed from: f */
    public EnumC2214ab m10114f() {
        return this.f8033g;
    }

    /* renamed from: g */
    public boolean m10115g() {
        return this.f8034h;
    }

    /* renamed from: h */
    public String m10116h() {
        return this.f8035i;
    }

    /* renamed from: i */
    public boolean m10117i() {
        return this.f8036j;
    }

    /* renamed from: j */
    public long m10118j() {
        return this.f8037k;
    }

    /* renamed from: k */
    public boolean m10119k() {
        if (this.f8028b.msgType.intValue() != 2 || TextUtils.isEmpty(this.f8028b.message)) {
            return false;
        }
        String[] strArrSplit = this.f8028b.message.split(",");
        return strArrSplit.length >= 3 && "REGISTERED".equals(strArrSplit[0]);
    }
}
