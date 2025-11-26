package com.sec.chaton.buddy.p010a;

import android.widget.ImageView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.c */
/* loaded from: classes.dex */
public class C0257c implements Serializable {

    /* renamed from: a */
    private String f1318a;

    /* renamed from: b */
    private String f1319b;

    /* renamed from: c */
    private String f1320c;

    /* renamed from: d */
    private String f1321d;

    /* renamed from: e */
    private String f1322e;

    /* renamed from: f */
    private String f1323f;

    /* renamed from: g */
    private boolean f1324g;

    /* renamed from: h */
    private int f1325h;

    /* renamed from: i */
    private String f1326i;

    /* renamed from: j */
    private boolean f1327j;

    /* renamed from: k */
    private boolean f1328k;

    /* renamed from: l */
    private boolean f1329l;

    /* renamed from: m */
    private int f1330m;

    /* renamed from: n */
    private int f1331n;

    /* renamed from: o */
    private int f1332o;

    /* renamed from: p */
    private int f1333p;

    /* renamed from: q */
    private int f1334q;

    /* renamed from: r */
    private int f1335r;

    /* renamed from: s */
    private boolean f1336s;

    /* renamed from: t */
    private int f1337t;

    /* renamed from: u */
    private ImageView f1338u;

    /* renamed from: v */
    private boolean f1339v;

    /* renamed from: w */
    private HashMap f1340w;

    /* renamed from: x */
    private int f1341x;

    /* renamed from: y */
    private String f1342y;

    public C0257c() {
        this.f1339v = false;
    }

    public C0257c(C0257c c0257c) {
        this.f1339v = false;
        this.f1318a = c0257c.m2318a();
        this.f1319b = c0257c.m2324b();
        this.f1320c = c0257c.m2327c();
        this.f1321d = c0257c.m2329d();
        this.f1322e = c0257c.m2331e();
        this.f1323f = c0257c.m2333f();
        this.f1324g = c0257c.m2335g();
        this.f1325h = c0257c.m2336h();
        this.f1326i = c0257c.m2337i();
        this.f1327j = c0257c.m2338j();
        this.f1330m = c0257c.m2339k();
        this.f1331n = c0257c.m2340l();
        this.f1332o = c0257c.m2341m();
        this.f1333p = c0257c.m2342n();
        this.f1334q = c0257c.m2343o();
        this.f1335r = c0257c.m2344p();
        this.f1336s = c0257c.m2345q();
        this.f1337t = c0257c.m2346r();
        this.f1329l = c0257c.m2349u();
        this.f1328k = c0257c.m2348t();
        this.f1339v = c0257c.m2350v();
        this.f1340w = new HashMap();
        HashMap mapM2351w = c0257c.m2351w();
        if (mapM2351w != null) {
            Iterator it = mapM2351w.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                this.f1340w.put(strValueOf, (String) mapM2351w.get(strValueOf));
            }
        }
        this.f1341x = c0257c.m2352x();
        this.f1342y = c0257c.m2353y();
    }

    public C0257c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2) {
        this.f1339v = false;
        this.f1318a = str;
        this.f1319b = str2;
        this.f1320c = str3;
        this.f1321d = str4;
        this.f1322e = str5;
        this.f1323f = str6;
        this.f1324g = z;
        this.f1325h = i;
        this.f1326i = str7;
        this.f1327j = z2;
        this.f1336s = false;
    }

    public C0257c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4) {
        this(str, str2, str3, str4, str5, str6, z, i, str7, z2, i2, i3, i4, i5, i6, i7, i8, z3, z4, 1, null);
    }

    public C0257c(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4, int i9, String str8) {
        this.f1339v = false;
        this.f1318a = str;
        this.f1319b = str2;
        this.f1320c = str3;
        this.f1321d = str4;
        this.f1322e = str5;
        this.f1323f = str6;
        this.f1324g = z;
        this.f1325h = i;
        this.f1326i = str7;
        this.f1327j = z2;
        this.f1330m = i2;
        this.f1331n = i3;
        this.f1332o = i4;
        this.f1333p = i5;
        this.f1334q = i6;
        this.f1335r = i7;
        this.f1336s = false;
        this.f1337t = i8;
        this.f1329l = z3;
        this.f1328k = z4;
        this.f1341x = i9;
        this.f1342y = str8;
    }

    /* renamed from: a */
    public String m2318a() {
        return this.f1318a;
    }

    /* renamed from: b */
    public String m2324b() {
        return this.f1319b;
    }

    /* renamed from: c */
    public String m2327c() {
        return this.f1320c;
    }

    /* renamed from: d */
    public String m2329d() {
        return this.f1321d;
    }

    /* renamed from: e */
    public String m2331e() {
        return this.f1322e;
    }

    /* renamed from: f */
    public String m2333f() {
        return this.f1323f;
    }

    /* renamed from: g */
    public boolean m2335g() {
        return this.f1324g;
    }

    /* renamed from: h */
    public int m2336h() {
        return this.f1325h;
    }

    /* renamed from: i */
    public String m2337i() {
        return this.f1326i;
    }

    /* renamed from: j */
    public boolean m2338j() {
        return this.f1327j;
    }

    /* renamed from: k */
    public int m2339k() {
        return this.f1330m;
    }

    /* renamed from: l */
    public int m2340l() {
        return this.f1331n;
    }

    /* renamed from: m */
    public int m2341m() {
        return this.f1332o;
    }

    /* renamed from: n */
    public int m2342n() {
        return this.f1333p;
    }

    /* renamed from: o */
    public int m2343o() {
        return this.f1334q;
    }

    /* renamed from: p */
    public int m2344p() {
        return this.f1335r;
    }

    /* renamed from: a */
    public void m2319a(int i) {
        this.f1330m = i;
    }

    /* renamed from: b */
    public void m2325b(int i) {
        this.f1331n = i;
    }

    /* renamed from: c */
    public void m2328c(int i) {
        this.f1332o = i;
    }

    /* renamed from: d */
    public void m2330d(int i) {
        this.f1333p = i;
    }

    /* renamed from: e */
    public void m2332e(int i) {
        this.f1334q = i;
    }

    /* renamed from: f */
    public void m2334f(int i) {
        this.f1335r = i;
    }

    /* renamed from: q */
    public boolean m2345q() {
        return this.f1336s;
    }

    /* renamed from: a */
    public void m2322a(boolean z) {
        this.f1336s = z;
    }

    /* renamed from: r */
    public int m2346r() {
        return this.f1337t;
    }

    /* renamed from: s */
    public ImageView m2347s() {
        return this.f1338u;
    }

    /* renamed from: a */
    public void m2320a(ImageView imageView) {
        this.f1338u = imageView;
    }

    /* renamed from: t */
    public boolean m2348t() {
        return this.f1328k;
    }

    /* renamed from: u */
    public boolean m2349u() {
        return this.f1329l;
    }

    /* renamed from: v */
    public boolean m2350v() {
        return this.f1339v;
    }

    /* renamed from: b */
    public void m2326b(boolean z) {
        this.f1339v = z;
    }

    /* renamed from: w */
    public HashMap m2351w() {
        return this.f1340w;
    }

    /* renamed from: a */
    public void m2321a(HashMap map) {
        this.f1340w = map;
    }

    /* renamed from: x */
    public int m2352x() {
        return this.f1341x;
    }

    /* renamed from: y */
    public String m2353y() {
        return this.f1342y;
    }

    /* renamed from: a */
    public boolean m2323a(String str) {
        return this.f1342y != null && this.f1342y.contains(new StringBuilder().append(str).append("=1").toString());
    }

    public String toString() {
        return "BuddyItem [no=" + this.f1318a + ", name=" + this.f1319b + ", statusMessage=" + this.f1320c + ", isShowRelationship=" + this.f1324g + ", pushName=" + this.f1326i + ", isNew=" + this.f1327j + ", relationSend=" + this.f1330m + ", relationReceived=" + this.f1331n + ", relationPoint=" + this.f1332o + ", relationLevel=" + this.f1333p + ", relationIncrease=" + this.f1334q + ", relationRank=" + this.f1335r + "]";
    }
}
