package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p113a.AbstractC4369f;
import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.sns.p115ui.DialogC4469aw;
import p021c.C0349h;
import p021c.p022a.C0333h;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bi */
/* loaded from: classes.dex */
public class C4410bi extends AbstractC4369f {

    /* renamed from: c */
    public static final String f15956c = C4410bi.class.getSimpleName();

    /* renamed from: d */
    private static C0349h f15957d;

    /* renamed from: e */
    private static C0333h f15958e;

    /* renamed from: f */
    private Handler f15959f;

    public C4410bi(Context context, InterfaceC4367d interfaceC4367d) {
        super(context, interfaceC4367d, f15956c);
        this.f15959f = new HandlerC4411bj(this);
        if (f15957d == null) {
            f15957d = new C0349h();
            C4445e.m16841a(f15957d, context);
        }
    }

    /* renamed from: a */
    public void m16750a(int i) {
        if (f15957d == null) {
            f15957d = new C0349h();
            C4445e.m16841a(f15957d, this.f15830a);
        }
        if (f15958e == null) {
            new AsyncTaskC4371h(this, 12005).execute(new C4415bn(this, null));
        } else {
            m16752a(f15958e);
        }
    }

    /* renamed from: b */
    public void m16753b() {
        new AsyncTaskC4371h(this, 12003).execute(new C4417bp(this, C4445e.m16849f(this.f15830a)));
    }

    /* renamed from: c */
    public boolean m16756c() {
        return C4445e.m16842b(this.f15830a);
    }

    /* renamed from: d */
    public String m16757d() {
        return C4445e.m16844c(this.f15830a);
    }

    /* renamed from: e */
    public String m16758e() {
        return C4445e.m16848e(this.f15830a);
    }

    /* renamed from: f */
    public String m16759f() {
        return C4445e.m16846d(this.f15830a);
    }

    /* renamed from: g */
    public String m16760g() {
        return C4445e.m16849f(this.f15830a);
    }

    /* renamed from: b */
    public void m16754b(int i) {
        new AsyncTaskC4371h(this, i).execute(new C4413bl(this, null));
    }

    /* renamed from: c */
    public void m16755c(int i) {
        new AsyncTaskC4371h(this, i).execute(new C4412bk(this, null));
    }

    /* renamed from: a */
    public void m16751a(int i, String str, String str2) {
        new AsyncTaskC4371h(this, i).execute(new C4416bo(this, str2, null));
    }

    /* renamed from: a */
    public static void m16740a(Context context) {
        C4445e.m16838a(context);
        f15957d = null;
        f15958e = null;
    }

    /* renamed from: a */
    public void m16752a(C0333h c0333h) {
        new DialogC4469aw(this.f15830a, f15957d, c0333h, new C4418bq(this, 12004)).show();
    }
}
