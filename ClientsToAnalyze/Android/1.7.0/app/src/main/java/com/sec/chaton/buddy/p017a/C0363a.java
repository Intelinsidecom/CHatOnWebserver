package com.sec.chaton.buddy.p017a;

import android.widget.ImageView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.a */
/* loaded from: classes.dex */
public class C0363a implements Serializable {

    /* renamed from: a */
    private String f1270a;

    /* renamed from: b */
    private String f1271b;

    /* renamed from: c */
    private String f1272c;

    /* renamed from: d */
    private String f1273d;

    /* renamed from: e */
    private String f1274e;

    /* renamed from: f */
    private String f1275f;

    /* renamed from: g */
    private boolean f1276g;

    /* renamed from: h */
    private int f1277h;

    /* renamed from: i */
    private String f1278i;

    /* renamed from: j */
    private boolean f1279j;

    /* renamed from: k */
    private boolean f1280k;

    /* renamed from: l */
    private boolean f1281l;

    /* renamed from: m */
    private int f1282m;

    /* renamed from: n */
    private int f1283n;

    /* renamed from: o */
    private int f1284o;

    /* renamed from: p */
    private int f1285p;

    /* renamed from: q */
    private int f1286q;

    /* renamed from: r */
    private int f1287r;

    /* renamed from: s */
    private boolean f1288s;

    /* renamed from: t */
    private int f1289t;

    /* renamed from: u */
    private ImageView f1290u;

    /* renamed from: v */
    private boolean f1291v;

    /* renamed from: w */
    private HashMap f1292w;

    /* renamed from: x */
    private int f1293x;

    /* renamed from: y */
    private String f1294y;

    public C0363a() {
        this.f1291v = false;
    }

    public C0363a(C0363a c0363a) {
        this.f1291v = false;
        this.f1270a = c0363a.m2308a();
        this.f1271b = c0363a.m2314b();
        this.f1272c = c0363a.m2316c();
        this.f1273d = c0363a.m2318d();
        this.f1274e = c0363a.m2319e();
        this.f1275f = c0363a.m2320f();
        this.f1276g = c0363a.m2321g();
        this.f1277h = c0363a.m2322h();
        this.f1278i = c0363a.m2323i();
        this.f1279j = c0363a.m2324j();
        this.f1282m = c0363a.m2325k();
        this.f1283n = c0363a.m2326l();
        this.f1284o = c0363a.m2327m();
        this.f1285p = c0363a.m2328n();
        this.f1286q = c0363a.m2329o();
        this.f1287r = c0363a.m2330p();
        this.f1288s = c0363a.m2331q();
        this.f1289t = c0363a.m2332r();
        this.f1281l = c0363a.m2335u();
        this.f1280k = c0363a.m2334t();
        this.f1291v = c0363a.m2336v();
        this.f1292w = new HashMap();
        HashMap mapM2337w = c0363a.m2337w();
        if (mapM2337w != null) {
            Iterator it = mapM2337w.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                this.f1292w.put(strValueOf, (String) mapM2337w.get(strValueOf));
            }
        }
        this.f1293x = c0363a.m2338x();
        this.f1294y = c0363a.m2339y();
    }

    public C0363a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2) {
        this.f1291v = false;
        this.f1270a = str;
        this.f1271b = str2;
        this.f1272c = str3;
        this.f1273d = str4;
        this.f1274e = str5;
        this.f1275f = str6;
        this.f1276g = z;
        this.f1277h = i;
        this.f1278i = str7;
        this.f1279j = z2;
        this.f1288s = false;
    }

    public C0363a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4) {
        this(str, str2, str3, str4, str5, str6, z, i, str7, z2, i2, i3, i4, i5, i6, i7, i8, z3, z4, 1, null);
    }

    public C0363a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8) {
        this.f1291v = false;
        this.f1270a = str;
        this.f1271b = str2;
        this.f1272c = str3;
        this.f1273d = str4;
        this.f1274e = str5;
        this.f1275f = str6;
        this.f1276g = z;
        this.f1277h = i;
        this.f1278i = str7;
        this.f1279j = z2;
        this.f1282m = i2;
        this.f1283n = i3;
        this.f1284o = i4;
        this.f1285p = i5;
        this.f1286q = i6;
        this.f1287r = i7;
        this.f1288s = false;
        this.f1289t = i8;
        this.f1281l = z3;
        this.f1280k = z4;
        this.f1293x = i9;
        this.f1294y = str8;
    }

    /* renamed from: a */
    public String m2308a() {
        return this.f1270a;
    }

    /* renamed from: b */
    public String m2314b() {
        return this.f1271b;
    }

    /* renamed from: c */
    public String m2316c() {
        return this.f1272c;
    }

    /* renamed from: d */
    public String m2318d() {
        return this.f1273d;
    }

    /* renamed from: e */
    public String m2319e() {
        return this.f1274e;
    }

    /* renamed from: f */
    public String m2320f() {
        return this.f1275f;
    }

    /* renamed from: g */
    public boolean m2321g() {
        return this.f1276g;
    }

    /* renamed from: h */
    public int m2322h() {
        return this.f1277h;
    }

    /* renamed from: i */
    public String m2323i() {
        return this.f1278i;
    }

    /* renamed from: j */
    public boolean m2324j() {
        return this.f1279j;
    }

    /* renamed from: k */
    public int m2325k() {
        return this.f1282m;
    }

    /* renamed from: l */
    public int m2326l() {
        return this.f1283n;
    }

    /* renamed from: m */
    public int m2327m() {
        return this.f1284o;
    }

    /* renamed from: n */
    public int m2328n() {
        return this.f1285p;
    }

    /* renamed from: o */
    public int m2329o() {
        return this.f1286q;
    }

    /* renamed from: p */
    public int m2330p() {
        return this.f1287r;
    }

    /* renamed from: a */
    public void m2309a(int i) {
        this.f1285p = i;
    }

    /* renamed from: b */
    public void m2315b(int i) {
        this.f1286q = i;
    }

    /* renamed from: c */
    public void m2317c(int i) {
        this.f1287r = i;
    }

    /* renamed from: q */
    public boolean m2331q() {
        return this.f1288s;
    }

    /* renamed from: r */
    public int m2332r() {
        return this.f1289t;
    }

    /* renamed from: s */
    public ImageView m2333s() {
        return this.f1290u;
    }

    /* renamed from: a */
    public void m2310a(ImageView imageView) {
        this.f1290u = imageView;
    }

    /* renamed from: t */
    public boolean m2334t() {
        return this.f1280k;
    }

    /* renamed from: u */
    public boolean m2335u() {
        return this.f1281l;
    }

    /* renamed from: v */
    public boolean m2336v() {
        return this.f1291v;
    }

    /* renamed from: a */
    public void m2312a(boolean z) {
        this.f1291v = z;
    }

    /* renamed from: w */
    public HashMap m2337w() {
        return this.f1292w;
    }

    /* renamed from: a */
    public void m2311a(HashMap map) {
        this.f1292w = map;
    }

    /* renamed from: x */
    public int m2338x() {
        return this.f1293x;
    }

    /* renamed from: y */
    public String m2339y() {
        return this.f1294y;
    }

    /* renamed from: a */
    public boolean m2313a(String str) {
        return this.f1294y != null && this.f1294y.contains(new StringBuilder().append(str).append("=1").toString());
    }

    public String toString() {
        return "BuddyItem [no=" + this.f1270a + ", name=" + this.f1271b + ", statusMessage=" + this.f1272c + ", isShowRelationship=" + this.f1276g + ", pushName=" + this.f1278i + ", isNew=" + this.f1279j + ", relationSend=" + this.f1282m + ", relationReceived=" + this.f1283n + ", relationPoint=" + this.f1284o + ", relationLevel=" + this.f1285p + ", relationIncrease=" + this.f1286q + ", relationRank=" + this.f1287r + "]";
    }
}
