package com.sec.chaton.buddy.p050a;

import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4830av;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.c */
/* loaded from: classes.dex */
public class C1106c implements Serializable {

    /* renamed from: A */
    private int f4214A;

    /* renamed from: B */
    private String f4215B;

    /* renamed from: C */
    private ArrayList<C4830av> f4216C;

    /* renamed from: D */
    private int f4217D;

    /* renamed from: E */
    private int f4218E;

    /* renamed from: F */
    private boolean f4219F;

    /* renamed from: G */
    private String f4220G;

    /* renamed from: H */
    private String f4221H;

    /* renamed from: I */
    private String f4222I;

    /* renamed from: J */
    private boolean f4223J;

    /* renamed from: K */
    private int f4224K;

    /* renamed from: L */
    private String f4225L;

    /* renamed from: a */
    String f4226a;

    /* renamed from: b */
    String f4227b;

    /* renamed from: c */
    String f4228c;

    /* renamed from: d */
    private String f4229d;

    /* renamed from: e */
    private String f4230e;

    /* renamed from: f */
    private String f4231f;

    /* renamed from: g */
    private String f4232g;

    /* renamed from: h */
    private String f4233h;

    /* renamed from: i */
    private boolean f4234i;

    /* renamed from: j */
    private String f4235j;

    /* renamed from: k */
    private boolean f4236k;

    /* renamed from: l */
    private int f4237l;

    /* renamed from: m */
    private String f4238m;

    /* renamed from: n */
    private boolean f4239n;

    /* renamed from: o */
    private boolean f4240o;

    /* renamed from: p */
    private boolean f4241p;

    /* renamed from: q */
    private int f4242q;

    /* renamed from: r */
    private int f4243r;

    /* renamed from: s */
    private int f4244s;

    /* renamed from: t */
    private int f4245t;

    /* renamed from: u */
    private int f4246u;

    /* renamed from: v */
    private int f4247v;

    /* renamed from: w */
    private boolean f4248w;

    /* renamed from: x */
    private int f4249x;

    /* renamed from: y */
    private boolean f4250y;

    /* renamed from: z */
    private HashMap<String, String> f4251z;

    public C1106c() {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
    }

    public C1106c(C1106c c1106c) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = c1106c.m7046a();
        this.f4230e = c1106c.m7051b();
        this.f4231f = c1106c.m7054c();
        this.f4232g = c1106c.m7055d();
        this.f4233h = c1106c.m7056e();
        this.f4235j = c1106c.m7059h();
        this.f4236k = c1106c.m7060i();
        this.f4237l = c1106c.m7061j();
        this.f4238m = c1106c.m7062k();
        this.f4239n = c1106c.m7063l();
        this.f4242q = c1106c.m7064m();
        this.f4243r = c1106c.m7065n();
        this.f4244s = c1106c.m7066o();
        this.f4245t = c1106c.m7067p();
        this.f4246u = c1106c.m7068q();
        this.f4247v = c1106c.m7069r();
        this.f4248w = c1106c.m7070s();
        this.f4249x = c1106c.m7071t();
        this.f4241p = c1106c.m7073v();
        this.f4240o = c1106c.m7072u();
        this.f4250y = c1106c.m7074w();
        this.f4251z = new HashMap<>();
        HashMap<String, String> mapM7076y = c1106c.m7076y();
        if (mapM7076y != null) {
            Iterator<String> it = mapM7076y.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                this.f4251z.put(strValueOf, mapM7076y.get(strValueOf));
            }
        }
        this.f4224K = c1106c.m7039B();
        this.f4225L = c1106c.m7040C();
        this.f4217D = c1106c.m7041D();
        this.f4228c = c1106c.m7058g();
        this.f4218E = c1106c.m7042E();
        this.f4220G = c1106c.m7043F();
        this.f4221H = c1106c.f4221H;
        this.f4223J = c1106c.m7045H();
    }

    public C1106c(String str, String str2) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = str;
        this.f4230e = str2;
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = str;
        this.f4230e = str2;
        this.f4231f = str3;
        this.f4232g = str4;
        this.f4233h = str5;
        this.f4235j = str6;
        this.f4236k = z;
        this.f4237l = i;
        this.f4238m = str7;
        this.f4239n = z2;
        this.f4248w = false;
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9) {
        this(str, str2, str3, str4, str5, str6, z, i, str7, z2, i2, i3, i4, i5, i6, i7, i8, z3, z4, 0, null, i9);
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = str;
        this.f4230e = str2;
        this.f4232g = str4;
        this.f4233h = str5;
        this.f4235j = str6;
        this.f4231f = str3;
        this.f4236k = z;
        this.f4238m = str7;
        this.f4239n = z2;
        this.f4237l = i;
        this.f4242q = i2;
        this.f4246u = i6;
        this.f4247v = i7;
        this.f4243r = i3;
        this.f4244s = i4;
        this.f4245t = i5;
        this.f4248w = false;
        this.f4240o = z4;
        this.f4241p = z3;
        this.f4249x = i8;
        this.f4225L = str8;
        this.f4224K = i9;
        this.f4217D = i10;
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10, String str9, String str10, String str11) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = str;
        this.f4230e = str2;
        this.f4231f = str3;
        this.f4232g = str4;
        this.f4233h = str5;
        this.f4235j = str6;
        this.f4236k = z;
        this.f4237l = i;
        this.f4238m = str7;
        this.f4239n = z2;
        this.f4242q = i2;
        this.f4245t = i5;
        this.f4248w = false;
        this.f4243r = i3;
        this.f4244s = i4;
        this.f4246u = i6;
        this.f4247v = i7;
        this.f4241p = z3;
        this.f4240o = z4;
        this.f4249x = i8;
        this.f4224K = i9;
        this.f4225L = str8;
        this.f4217D = i10;
        this.f4228c = str9;
        this.f4220G = str10;
        this.f4221H = str11;
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, boolean z2, int i, String str9, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z4, boolean z5, int i9, String str10, int i10, String str11, String str12, String str13) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4229d = str;
        this.f4230e = str2;
        this.f4231f = str3;
        this.f4232g = str4;
        this.f4233h = str5;
        this.f4226a = str6;
        this.f4227b = str7;
        this.f4234i = z;
        this.f4235j = str8;
        this.f4236k = z2;
        this.f4237l = i;
        this.f4238m = str9;
        this.f4239n = z3;
        this.f4242q = i2;
        this.f4243r = i3;
        this.f4244s = i4;
        this.f4245t = i5;
        this.f4246u = i6;
        this.f4247v = i7;
        this.f4248w = false;
        this.f4249x = i8;
        this.f4241p = z4;
        this.f4240o = z5;
        this.f4224K = i9;
        this.f4225L = str10;
        this.f4228c = str11;
        this.f4217D = i10;
        this.f4220G = str12;
        this.f4221H = str13;
    }

    public C1106c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8, int i10, String str9, String str10, ArrayList<C4830av> arrayList, int i11, String str11, String str12, String str13, String str14) {
        this.f4250y = false;
        this.f4218E = -1;
        this.f4219F = false;
        this.f4220G = Spam.ACTIVITY_CANCEL;
        this.f4221H = "";
        this.f4222I = "";
        this.f4223J = false;
        this.f4231f = str3;
        this.f4232g = str4;
        this.f4229d = str;
        this.f4230e = str2;
        this.f4235j = str6;
        this.f4233h = str5;
        this.f4237l = i;
        this.f4238m = str7;
        this.f4236k = z;
        this.f4239n = z2;
        this.f4245t = i5;
        this.f4242q = i2;
        this.f4243r = i3;
        this.f4244s = i4;
        this.f4246u = i6;
        this.f4247v = i7;
        this.f4240o = z4;
        this.f4249x = i8;
        this.f4241p = z3;
        this.f4248w = false;
        this.f4225L = str8;
        this.f4224K = i9;
        this.f4214A = i10;
        this.f4227b = str9;
        this.f4215B = str10;
        this.f4216C = arrayList;
        this.f4217D = i11;
        this.f4228c = str11;
        this.f4220G = str12;
        this.f4221H = str13;
        this.f4222I = str14;
    }

    /* renamed from: a */
    public String m7046a() {
        return this.f4229d;
    }

    /* renamed from: b */
    public String m7051b() {
        return this.f4230e;
    }

    /* renamed from: c */
    public String m7054c() {
        return this.f4231f;
    }

    /* renamed from: d */
    public String m7055d() {
        return this.f4232g;
    }

    /* renamed from: e */
    public String m7056e() {
        return this.f4233h;
    }

    /* renamed from: f */
    public String m7057f() {
        return this.f4227b;
    }

    /* renamed from: g */
    public String m7058g() {
        return this.f4228c;
    }

    /* renamed from: h */
    public String m7059h() {
        return this.f4235j;
    }

    /* renamed from: i */
    public boolean m7060i() {
        return this.f4236k;
    }

    /* renamed from: j */
    public int m7061j() {
        return this.f4237l;
    }

    /* renamed from: k */
    public String m7062k() {
        return this.f4238m;
    }

    /* renamed from: l */
    public boolean m7063l() {
        return this.f4239n;
    }

    /* renamed from: m */
    public int m7064m() {
        return this.f4242q;
    }

    /* renamed from: n */
    public int m7065n() {
        return this.f4243r;
    }

    /* renamed from: o */
    public int m7066o() {
        return this.f4244s;
    }

    /* renamed from: p */
    public int m7067p() {
        return this.f4245t;
    }

    /* renamed from: q */
    public int m7068q() {
        return this.f4246u;
    }

    /* renamed from: r */
    public int m7069r() {
        return this.f4247v;
    }

    /* renamed from: s */
    public boolean m7070s() {
        return this.f4248w;
    }

    /* renamed from: t */
    public int m7071t() {
        return this.f4249x;
    }

    /* renamed from: u */
    public boolean m7072u() {
        return this.f4240o;
    }

    /* renamed from: v */
    public boolean m7073v() {
        return this.f4241p;
    }

    /* renamed from: w */
    public boolean m7074w() {
        return this.f4250y;
    }

    /* renamed from: a */
    public void m7049a(boolean z) {
        this.f4250y = z;
    }

    /* renamed from: x */
    public int m7075x() {
        return this.f4214A;
    }

    /* renamed from: y */
    public HashMap<String, String> m7076y() {
        return this.f4251z;
    }

    /* renamed from: z */
    public String m7077z() {
        return this.f4215B;
    }

    /* renamed from: A */
    public ArrayList<C4830av> m7038A() {
        return this.f4216C;
    }

    /* renamed from: a */
    public void m7048a(HashMap<String, String> map) {
        this.f4251z = map;
    }

    /* renamed from: B */
    public int m7039B() {
        return this.f4224K;
    }

    /* renamed from: C */
    public String m7040C() {
        return this.f4225L;
    }

    /* renamed from: D */
    public int m7041D() {
        return this.f4217D;
    }

    /* renamed from: a */
    public boolean m7050a(String str) {
        return this.f4225L != null && this.f4225L.contains(new StringBuilder().append(str).append("=1").toString());
    }

    /* renamed from: E */
    public int m7042E() {
        return this.f4218E;
    }

    /* renamed from: a */
    public void m7047a(int i) {
        this.f4218E = i;
    }

    /* renamed from: F */
    public String m7043F() {
        return this.f4220G;
    }

    /* renamed from: G */
    public String m7044G() {
        return this.f4221H;
    }

    /* renamed from: b */
    public void m7052b(String str) {
        this.f4230e = str;
    }

    /* renamed from: H */
    public boolean m7045H() {
        return this.f4223J;
    }

    /* renamed from: b */
    public void m7053b(boolean z) {
        this.f4223J = z;
    }

    public String toString() {
        return "BuddyItem [no=" + this.f4229d + ", name=" + this.f4230e + ", statusMessage=" + this.f4231f + ", isShowRelationship=" + this.f4236k + ", pushName=" + this.f4238m + ", isNew=" + this.f4239n + ", relationSend=" + this.f4242q + ", relationReceived=" + this.f4243r + ", relationPoint=" + this.f4244s + ", relationLevel=" + this.f4245t + ", relationIncrease=" + this.f4246u + ", relationRank=" + this.f4247v + "]";
    }
}
