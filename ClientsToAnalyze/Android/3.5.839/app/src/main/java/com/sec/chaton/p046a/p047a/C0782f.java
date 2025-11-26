package com.sec.chaton.p046a.p047a;

import com.sec.chaton.p057e.EnumC2214ab;
import java.util.ArrayList;

/* compiled from: DeliveryChatResultEntry.java */
/* renamed from: com.sec.chaton.a.a.f */
/* loaded from: classes.dex */
public class C0782f extends C0788l {

    /* renamed from: d */
    private String f2117d;

    /* renamed from: e */
    private boolean f2118e;

    /* renamed from: f */
    private int f2119f;

    /* renamed from: g */
    private ArrayList<String> f2120g;

    /* renamed from: h */
    private String f2121h;

    /* renamed from: i */
    private String f2122i;

    /* renamed from: j */
    private EnumC2214ab f2123j;

    protected C0782f(C0783g c0783g) {
        super(c0783g.f2124a, c0783g.f2125b);
        this.f2117d = c0783g.f2127d;
        this.f2118e = c0783g.f2128e;
        this.f2119f = c0783g.f2129f;
        this.f2122i = c0783g.f2130g;
        this.f2121h = c0783g.f2131h;
        this.f2123j = c0783g.f2132i;
        this.f2120g = new ArrayList<>(c0783g.f2133j);
    }

    /* renamed from: a */
    public boolean m3117a() {
        return this.f2118e;
    }

    /* renamed from: b */
    public int m3118b() {
        return this.f2119f;
    }

    /* renamed from: c */
    public String m3119c() {
        return this.f2121h;
    }

    /* renamed from: d */
    public String m3120d() {
        return this.f2122i;
    }

    /* renamed from: e */
    public EnumC2214ab m3121e() {
        return this.f2123j;
    }

    /* renamed from: f */
    public String[] m3122f() {
        return (String[]) this.f2120g.toArray(new String[0]);
    }
}
