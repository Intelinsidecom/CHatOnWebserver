package com.sec.chaton.buddy.item;

import android.widget.ImageView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyItem implements Serializable {

    /* renamed from: a */
    private String f673a;

    /* renamed from: b */
    private String f674b;

    /* renamed from: c */
    private String f675c;

    /* renamed from: d */
    private String f676d;

    /* renamed from: e */
    private String f677e;

    /* renamed from: f */
    private String f678f;

    /* renamed from: g */
    private boolean f679g;

    /* renamed from: h */
    private int f680h;

    /* renamed from: i */
    private String f681i;

    /* renamed from: j */
    private boolean f682j;

    /* renamed from: k */
    private boolean f683k;

    /* renamed from: l */
    private boolean f684l;

    /* renamed from: m */
    private int f685m;

    /* renamed from: n */
    private int f686n;

    /* renamed from: o */
    private int f687o;

    /* renamed from: p */
    private int f688p;

    /* renamed from: q */
    private int f689q;

    /* renamed from: r */
    private int f690r;

    /* renamed from: s */
    private boolean f691s;

    /* renamed from: t */
    private int f692t;

    /* renamed from: u */
    private ImageView f693u;

    /* renamed from: v */
    private boolean f694v;

    /* renamed from: w */
    private HashMap f695w;

    /* renamed from: x */
    private int f696x;

    public BuddyItem() {
        this.f694v = false;
    }

    public BuddyItem(BuddyItem buddyItem) {
        this.f694v = false;
        this.f673a = buddyItem.m668a();
        this.f674b = buddyItem.m673b();
        this.f675c = buddyItem.m676c();
        this.f676d = buddyItem.m678d();
        this.f677e = buddyItem.m680e();
        this.f678f = buddyItem.m681f();
        this.f679g = buddyItem.m682g();
        this.f680h = buddyItem.m683h();
        this.f681i = buddyItem.m684i();
        this.f682j = buddyItem.m685j();
        this.f685m = buddyItem.m686k();
        this.f686n = buddyItem.m687l();
        this.f687o = buddyItem.m688m();
        this.f688p = buddyItem.m689n();
        this.f689q = buddyItem.m690o();
        this.f690r = buddyItem.m691p();
        this.f691s = buddyItem.m692q();
        this.f692t = buddyItem.m693r();
        this.f684l = buddyItem.m696u();
        this.f683k = buddyItem.m695t();
        this.f694v = buddyItem.m697v();
        this.f695w = new HashMap();
        HashMap mapM698w = buddyItem.m698w();
        if (mapM698w != null) {
            Iterator it = mapM698w.keySet().iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                this.f695w.put(strValueOf, (String) mapM698w.get(strValueOf));
            }
        }
    }

    public BuddyItem(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2) {
        this.f694v = false;
        this.f673a = str;
        this.f674b = str2;
        this.f675c = str3;
        this.f676d = str4;
        this.f677e = str5;
        this.f678f = str6;
        this.f679g = z;
        this.f680h = i;
        this.f681i = str7;
        this.f682j = z2;
        this.f691s = false;
    }

    public BuddyItem(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, boolean z4) {
        this.f694v = false;
        this.f673a = str;
        this.f674b = str2;
        this.f675c = str3;
        this.f676d = str4;
        this.f677e = str5;
        this.f678f = str6;
        this.f679g = z;
        this.f680h = i;
        this.f681i = str7;
        this.f682j = z2;
        this.f685m = i2;
        this.f686n = i3;
        this.f687o = i4;
        this.f688p = i5;
        this.f689q = i6;
        this.f690r = i7;
        this.f691s = false;
        this.f692t = i8;
        this.f684l = z3;
        this.f683k = z4;
    }

    /* renamed from: a */
    public String m668a() {
        return this.f673a;
    }

    /* renamed from: a */
    public void m669a(int i) {
        this.f688p = i;
    }

    /* renamed from: a */
    public void m670a(ImageView imageView) {
        this.f693u = imageView;
    }

    /* renamed from: a */
    public void m671a(HashMap map) {
        this.f695w = map;
    }

    /* renamed from: a */
    public void m672a(boolean z) {
        this.f691s = z;
    }

    /* renamed from: b */
    public String m673b() {
        return this.f674b;
    }

    /* renamed from: b */
    public void m674b(int i) {
        this.f689q = i;
    }

    /* renamed from: b */
    public void m675b(boolean z) {
        this.f694v = z;
    }

    /* renamed from: c */
    public String m676c() {
        return this.f675c;
    }

    /* renamed from: c */
    public void m677c(int i) {
        this.f690r = i;
    }

    /* renamed from: d */
    public String m678d() {
        return this.f676d;
    }

    /* renamed from: d */
    public void m679d(int i) {
        this.f696x = i;
    }

    /* renamed from: e */
    public String m680e() {
        return this.f677e;
    }

    /* renamed from: f */
    public String m681f() {
        return this.f678f;
    }

    /* renamed from: g */
    public boolean m682g() {
        return this.f679g;
    }

    /* renamed from: h */
    public int m683h() {
        return this.f680h;
    }

    /* renamed from: i */
    public String m684i() {
        return this.f681i;
    }

    /* renamed from: j */
    public boolean m685j() {
        return this.f682j;
    }

    /* renamed from: k */
    public int m686k() {
        return this.f685m;
    }

    /* renamed from: l */
    public int m687l() {
        return this.f686n;
    }

    /* renamed from: m */
    public int m688m() {
        return this.f687o;
    }

    /* renamed from: n */
    public int m689n() {
        return this.f688p;
    }

    /* renamed from: o */
    public int m690o() {
        return this.f689q;
    }

    /* renamed from: p */
    public int m691p() {
        return this.f690r;
    }

    /* renamed from: q */
    public boolean m692q() {
        return this.f691s;
    }

    /* renamed from: r */
    public int m693r() {
        return this.f692t;
    }

    /* renamed from: s */
    public ImageView m694s() {
        return this.f693u;
    }

    /* renamed from: t */
    public boolean m695t() {
        return this.f683k;
    }

    public String toString() {
        return "BuddyItem [no=" + this.f673a + ", name=" + this.f674b + ", statusMessage=" + this.f675c + ", isShowRelationship=" + this.f679g + ", pushName=" + this.f681i + ", isNew=" + this.f682j + ", relationSend=" + this.f685m + ", relationReceived=" + this.f686n + ", relationPoint=" + this.f687o + ", relationLevel=" + this.f688p + ", relationIncrease=" + this.f689q + ", relationRank=" + this.f690r + "]";
    }

    /* renamed from: u */
    public boolean m696u() {
        return this.f684l;
    }

    /* renamed from: v */
    public boolean m697v() {
        return this.f694v;
    }

    /* renamed from: w */
    public HashMap m698w() {
        return this.f695w;
    }

    /* renamed from: x */
    public int m699x() {
        return this.f696x;
    }
}
