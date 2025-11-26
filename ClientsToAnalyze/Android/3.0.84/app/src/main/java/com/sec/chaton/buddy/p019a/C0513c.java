package com.sec.chaton.buddy.p019a;

import com.sec.chaton.util.C3180av;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.c */
/* loaded from: classes.dex */
public class C0513c implements Serializable {

    /* renamed from: A */
    private HashMap<String, String> f2364A;

    /* renamed from: B */
    private int f2365B;

    /* renamed from: C */
    private String f2366C;

    /* renamed from: D */
    private ArrayList<C3180av> f2367D;

    /* renamed from: E */
    private int f2368E;

    /* renamed from: F */
    private int f2369F;

    /* renamed from: G */
    private boolean f2370G;

    /* renamed from: H */
    private int f2371H;

    /* renamed from: I */
    private String f2372I;

    /* renamed from: a */
    String f2373a;

    /* renamed from: b */
    String f2374b;

    /* renamed from: c */
    String f2375c;

    /* renamed from: d */
    private int f2376d;

    /* renamed from: e */
    private String f2377e;

    /* renamed from: f */
    private String f2378f;

    /* renamed from: g */
    private String f2379g;

    /* renamed from: h */
    private String f2380h;

    /* renamed from: i */
    private String f2381i;

    /* renamed from: j */
    private boolean f2382j;

    /* renamed from: k */
    private String f2383k;

    /* renamed from: l */
    private boolean f2384l;

    /* renamed from: m */
    private int f2385m;

    /* renamed from: n */
    private String f2386n;

    /* renamed from: o */
    private boolean f2387o;

    /* renamed from: p */
    private boolean f2388p;

    /* renamed from: q */
    private boolean f2389q;

    /* renamed from: r */
    private int f2390r;

    /* renamed from: s */
    private int f2391s;

    /* renamed from: t */
    private int f2392t;

    /* renamed from: u */
    private int f2393u;

    /* renamed from: v */
    private int f2394v;

    /* renamed from: w */
    private int f2395w;

    /* renamed from: x */
    private boolean f2396x;

    /* renamed from: y */
    private int f2397y;

    /* renamed from: z */
    private boolean f2398z;

    public C0513c() {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
    }

    public C0513c(C0513c c0513c) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = c0513c.m3975b();
        this.f2378f = c0513c.m3976c();
        this.f2379g = c0513c.m3977d();
        this.f2380h = c0513c.m3978e();
        this.f2381i = c0513c.m3979f();
        this.f2383k = c0513c.m3982i();
        this.f2384l = c0513c.m3983j();
        this.f2385m = c0513c.m3984k();
        this.f2386n = c0513c.m3985l();
        this.f2387o = c0513c.m3986m();
        this.f2390r = c0513c.m3987n();
        this.f2391s = c0513c.m3988o();
        this.f2392t = c0513c.m3989p();
        this.f2393u = c0513c.m3990q();
        this.f2394v = c0513c.m3991r();
        this.f2395w = c0513c.m3992s();
        this.f2396x = c0513c.m3993t();
        this.f2397y = c0513c.m3994u();
        this.f2389q = c0513c.m3996w();
        this.f2388p = c0513c.m3995v();
        this.f2398z = c0513c.m3997x();
        this.f2364A = new HashMap<>();
        HashMap<String, String> mapM3999z = c0513c.m3999z();
        if (mapM3999z != null) {
            Iterator<String> it = mapM3999z.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                this.f2364A.put(strValueOf, mapM3999z.get(strValueOf));
            }
        }
        this.f2371H = c0513c.m3966C();
        this.f2372I = c0513c.m3967D();
        this.f2368E = c0513c.m3968E();
        this.f2375c = c0513c.m3981h();
        this.f2369F = c0513c.m3969F();
    }

    public C0513c(String str, String str2) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
        this.f2379g = str3;
        this.f2380h = str4;
        this.f2381i = str5;
        this.f2383k = str6;
        this.f2384l = z;
        this.f2385m = i;
        this.f2386n = str7;
        this.f2387o = z2;
        this.f2396x = false;
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9) {
        this(str, str2, str3, str4, str5, str6, z, i, str7, z2, i2, i3, i4, i5, i6, i7, i8, z3, z4, 0, null, i9);
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
        this.f2379g = str3;
        this.f2380h = str4;
        this.f2381i = str5;
        this.f2383k = str6;
        this.f2384l = z;
        this.f2385m = i;
        this.f2386n = str7;
        this.f2387o = z2;
        this.f2390r = i2;
        this.f2391s = i3;
        this.f2392t = i4;
        this.f2393u = i5;
        this.f2394v = i6;
        this.f2395w = i7;
        this.f2396x = false;
        this.f2397y = i8;
        this.f2389q = z3;
        this.f2388p = z4;
        this.f2371H = i9;
        this.f2372I = str8;
        this.f2368E = i10;
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10, String str9) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
        this.f2379g = str3;
        this.f2380h = str4;
        this.f2381i = str5;
        this.f2383k = str6;
        this.f2384l = z;
        this.f2385m = i;
        this.f2386n = str7;
        this.f2387o = z2;
        this.f2390r = i2;
        this.f2391s = i3;
        this.f2392t = i4;
        this.f2393u = i5;
        this.f2394v = i6;
        this.f2395w = i7;
        this.f2396x = false;
        this.f2397y = i8;
        this.f2389q = z3;
        this.f2388p = z4;
        this.f2371H = i9;
        this.f2372I = str8;
        this.f2368E = i10;
        this.f2375c = str9;
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, boolean z2, int i, String str9, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z4, boolean z5, int i9, String str10, int i10, String str11) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
        this.f2379g = str3;
        this.f2380h = str4;
        this.f2381i = str5;
        this.f2373a = str6;
        this.f2374b = str7;
        this.f2382j = z;
        this.f2383k = str8;
        this.f2384l = z2;
        this.f2385m = i;
        this.f2386n = str9;
        this.f2387o = z3;
        this.f2390r = i2;
        this.f2391s = i3;
        this.f2392t = i4;
        this.f2393u = i5;
        this.f2394v = i6;
        this.f2395w = i7;
        this.f2396x = false;
        this.f2397y = i8;
        this.f2389q = z4;
        this.f2388p = z5;
        this.f2371H = i9;
        this.f2372I = str10;
        this.f2375c = str11;
        this.f2368E = i10;
    }

    public C0513c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10, String str9, String str10, ArrayList<C3180av> arrayList, int i11, String str11) {
        this.f2398z = false;
        this.f2369F = -1;
        this.f2370G = false;
        this.f2377e = str;
        this.f2378f = str2;
        this.f2379g = str3;
        this.f2380h = str4;
        this.f2381i = str5;
        this.f2383k = str6;
        this.f2384l = z;
        this.f2385m = i;
        this.f2386n = str7;
        this.f2387o = z2;
        this.f2390r = i2;
        this.f2391s = i3;
        this.f2392t = i4;
        this.f2393u = i5;
        this.f2394v = i6;
        this.f2395w = i7;
        this.f2396x = false;
        this.f2397y = i8;
        this.f2389q = z3;
        this.f2388p = z4;
        this.f2371H = i9;
        this.f2372I = str8;
        this.f2365B = i10;
        this.f2374b = str9;
        this.f2366C = str10;
        this.f2367D = arrayList;
        this.f2368E = i11;
        this.f2375c = str11;
    }

    /* renamed from: a */
    public int m3970a() {
        return this.f2376d;
    }

    /* renamed from: b */
    public String m3975b() {
        return this.f2377e;
    }

    /* renamed from: c */
    public String m3976c() {
        return this.f2378f;
    }

    /* renamed from: d */
    public String m3977d() {
        return this.f2379g;
    }

    /* renamed from: e */
    public String m3978e() {
        return this.f2380h;
    }

    /* renamed from: f */
    public String m3979f() {
        return this.f2381i;
    }

    /* renamed from: g */
    public String m3980g() {
        return this.f2374b;
    }

    /* renamed from: h */
    public String m3981h() {
        return this.f2375c;
    }

    /* renamed from: i */
    public String m3982i() {
        return this.f2383k;
    }

    /* renamed from: j */
    public boolean m3983j() {
        return this.f2384l;
    }

    /* renamed from: k */
    public int m3984k() {
        return this.f2385m;
    }

    /* renamed from: l */
    public String m3985l() {
        return this.f2386n;
    }

    /* renamed from: m */
    public boolean m3986m() {
        return this.f2387o;
    }

    /* renamed from: n */
    public int m3987n() {
        return this.f2390r;
    }

    /* renamed from: o */
    public int m3988o() {
        return this.f2391s;
    }

    /* renamed from: p */
    public int m3989p() {
        return this.f2392t;
    }

    /* renamed from: q */
    public int m3990q() {
        return this.f2393u;
    }

    /* renamed from: r */
    public int m3991r() {
        return this.f2394v;
    }

    /* renamed from: s */
    public int m3992s() {
        return this.f2395w;
    }

    /* renamed from: t */
    public boolean m3993t() {
        return this.f2396x;
    }

    /* renamed from: u */
    public int m3994u() {
        return this.f2397y;
    }

    /* renamed from: v */
    public boolean m3995v() {
        return this.f2388p;
    }

    /* renamed from: w */
    public boolean m3996w() {
        return this.f2389q;
    }

    /* renamed from: x */
    public boolean m3997x() {
        return this.f2398z;
    }

    /* renamed from: a */
    public void m3973a(boolean z) {
        this.f2398z = z;
    }

    /* renamed from: y */
    public int m3998y() {
        return this.f2365B;
    }

    /* renamed from: z */
    public HashMap<String, String> m3999z() {
        return this.f2364A;
    }

    /* renamed from: A */
    public String m3964A() {
        return this.f2366C;
    }

    /* renamed from: B */
    public ArrayList<C3180av> m3965B() {
        return this.f2367D;
    }

    /* renamed from: a */
    public void m3972a(HashMap<String, String> map) {
        this.f2364A = map;
    }

    /* renamed from: C */
    public int m3966C() {
        return this.f2371H;
    }

    /* renamed from: D */
    public String m3967D() {
        return this.f2372I;
    }

    /* renamed from: E */
    public int m3968E() {
        return this.f2368E;
    }

    /* renamed from: a */
    public boolean m3974a(String str) {
        return this.f2372I != null && this.f2372I.contains(new StringBuilder().append(str).append("=1").toString());
    }

    /* renamed from: F */
    public int m3969F() {
        return this.f2369F;
    }

    /* renamed from: a */
    public void m3971a(int i) {
        this.f2369F = i;
    }

    public String toString() {
        return "BuddyItem [no=" + this.f2377e + ", name=" + this.f2378f + ", statusMessage=" + this.f2379g + ", isShowRelationship=" + this.f2384l + ", pushName=" + this.f2386n + ", isNew=" + this.f2387o + ", relationSend=" + this.f2390r + ", relationReceived=" + this.f2391s + ", relationPoint=" + this.f2392t + ", relationLevel=" + this.f2393u + ", relationIncrease=" + this.f2394v + ", relationRank=" + this.f2395w + "]";
    }
}
