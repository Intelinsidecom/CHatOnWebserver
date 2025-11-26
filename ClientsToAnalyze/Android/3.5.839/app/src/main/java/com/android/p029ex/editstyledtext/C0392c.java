package com.android.p029ex.editstyledtext;

import android.util.Log;
import java.util.HashMap;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.c */
/* loaded from: classes.dex */
public class C0392c {

    /* renamed from: a */
    final /* synthetic */ EditStyledText f952a;

    /* renamed from: b */
    private EditStyledText f953b;

    /* renamed from: c */
    private C0371ak f954c;

    /* renamed from: d */
    private C0376ap f955d;

    /* renamed from: e */
    private int f956e = 0;

    /* renamed from: f */
    private HashMap<Integer, C0400k> f957f = new HashMap<>();

    /* renamed from: g */
    private C0405p f958g = new C0405p(this);

    /* renamed from: h */
    private C0398i f959h = new C0398i(this);

    /* renamed from: i */
    private C0406q f960i = new C0406q(this);

    /* renamed from: j */
    private C0409t f961j = new C0409t(this);

    /* renamed from: k */
    private C0399j f962k = new C0399j(this);

    /* renamed from: l */
    private C0410u f963l = new C0410u(this);

    /* renamed from: m */
    private C0402m f964m = new C0402m(this);

    /* renamed from: n */
    private C0415z f965n = new C0415z(this);

    /* renamed from: o */
    private C0396g f966o = new C0396g(this);

    /* renamed from: p */
    private C0403n f967p = new C0403n(this);

    /* renamed from: q */
    private C0394e f968q = new C0394e(this);

    /* renamed from: r */
    private C0407r f969r = new C0407r(this);

    /* renamed from: s */
    private C0395f f970s = new C0395f(this);

    /* renamed from: t */
    private C0363ac f971t = new C0363ac(this);

    /* renamed from: u */
    private C0414y f972u = new C0414y(this);

    /* renamed from: v */
    private C0401l f973v = new C0401l(this);

    /* renamed from: w */
    private C0408s f974w = new C0408s(this);

    /* renamed from: x */
    private C0412w f975x = new C0412w(this);

    /* renamed from: y */
    private C0393d f976y = new C0393d(this);

    /* renamed from: z */
    private C0362ab f977z = new C0362ab(this);

    /* renamed from: A */
    private C0361aa f948A = new C0361aa(this);

    /* renamed from: B */
    private C0404o f949B = new C0404o(this);

    /* renamed from: C */
    private C0397h f950C = new C0397h(this);

    /* renamed from: D */
    private C0413x f951D = new C0413x(this);

    C0392c(EditStyledText editStyledText, EditStyledText editStyledText2, C0371ak c0371ak, C0376ap c0376ap) {
        this.f952a = editStyledText;
        this.f953b = editStyledText2;
        this.f954c = c0371ak;
        this.f955d = c0376ap;
        this.f957f.put(0, this.f958g);
        this.f957f.put(1, this.f959h);
        this.f957f.put(2, this.f960i);
        this.f957f.put(5, this.f961j);
        this.f957f.put(7, this.f962k);
        this.f957f.put(11, this.f963l);
        this.f957f.put(12, this.f964m);
        this.f957f.put(13, this.f965n);
        this.f957f.put(14, this.f966o);
        this.f957f.put(15, this.f967p);
        this.f957f.put(16, this.f968q);
        this.f957f.put(17, this.f969r);
        this.f957f.put(18, this.f970s);
        this.f957f.put(19, this.f971t);
        this.f957f.put(20, this.f972u);
        this.f957f.put(21, this.f973v);
        this.f957f.put(22, this.f974w);
        this.f957f.put(23, this.f975x);
        this.f957f.put(6, this.f976y);
        this.f957f.put(8, this.f977z);
        this.f957f.put(9, this.f948A);
        this.f957f.put(10, this.f949B);
        this.f957f.put(4, this.f950C);
        this.f957f.put(3, this.f951D);
    }

    /* renamed from: a */
    public void m1459a(int i, Object[] objArr) {
        m1455c(i).m1464a(objArr);
        this.f956e = i;
        m1461b(i);
    }

    /* renamed from: a */
    public void m1458a(int i) {
        m1459a(i, null);
    }

    /* renamed from: a */
    public void m1457a() {
        m1461b(5);
    }

    /* renamed from: c */
    private C0400k m1455c(int i) {
        if (this.f957f.containsKey(Integer.valueOf(i))) {
            return this.f957f.get(Integer.valueOf(i));
        }
        return null;
    }

    /* renamed from: b */
    public boolean m1460b() {
        return m1461b(this.f956e);
    }

    /* renamed from: b */
    public boolean m1461b(int i) {
        Log.d("EditModeActions", "--- do the next action: " + i + "," + this.f954c.m1411o());
        C0400k c0400kM1455c = m1455c(i);
        if (c0400kM1455c == null) {
            Log.e("EditModeActions", "--- invalid action error.");
            return false;
        }
        switch (this.f954c.m1411o()) {
            case 0:
                return c0400kM1455c.mo1305b();
            case 1:
                return c0400kM1455c.mo1465e();
            case 2:
                return c0400kM1455c.mo1304d();
            case 3:
                if (this.f954c.m1408l()) {
                    return c0400kM1455c.mo1462c();
                }
                return c0400kM1455c.mo1303a();
            default:
                return false;
        }
    }
}
