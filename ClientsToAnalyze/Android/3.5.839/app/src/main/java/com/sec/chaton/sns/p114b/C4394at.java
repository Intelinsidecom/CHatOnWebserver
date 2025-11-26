package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.C4443c;
import com.sec.chaton.sns.p113a.AbstractC4369f;
import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.sns.p115ui.DialogC4455ai;
import p010b.C0321h;
import p010b.InterfaceC0319f;
import p010b.p012b.C0280i;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.at */
/* loaded from: classes.dex */
public class C4394at extends AbstractC4369f {

    /* renamed from: c */
    public static final String f15920c = C4394at.class.getSimpleName();

    /* renamed from: d */
    private static final String f15921d = C1428b.f5113s + "?oauth_token=";

    /* renamed from: e */
    private static InterfaceC0319f f15922e;

    /* renamed from: f */
    private static C0280i f15923f;

    /* renamed from: g */
    private C4397aw f15924g;

    /* renamed from: h */
    private Handler f15925h;

    public C4394at(Context context, InterfaceC4367d interfaceC4367d) {
        super(context, interfaceC4367d, f15920c);
        this.f15925h = new HandlerC4395au(this);
        if (f15922e == null) {
            f15922e = new C0321h().m1082a();
            C4443c.m16822a(f15922e, context);
        }
    }

    /* renamed from: a */
    public void m16702a(int i) {
        if (f15922e == null) {
            f15922e = new C0321h().m1082a();
            C4443c.m16822a(f15922e, this.f15830a);
        }
        if (f15923f == null) {
            new AsyncTaskC4371h(this, 12005).execute(new C4399ay(this, null));
        } else {
            m16708c(f15923f.mo954c());
        }
    }

    /* renamed from: b */
    public boolean m16705b() {
        return C4443c.m16819a(this.f15830a);
    }

    /* renamed from: c */
    public void m16708c(String str) {
        new DialogC4455ai(this.f15830a, f15922e, f15921d + str, new C4400az(this, 12004)).show();
    }

    /* renamed from: c */
    public String m16706c() {
        return C4443c.m16823b(this.f15830a);
    }

    /* renamed from: d */
    public String m16709d() {
        return C4443c.m16827d(this.f15830a);
    }

    /* renamed from: e */
    public String m16710e() {
        return C4443c.m16825c(this.f15830a);
    }

    /* renamed from: b */
    public void m16704b(int i) {
        if (this.f15924g == null) {
            this.f15924g = new C4397aw(this, null);
        }
        if (this.f15924g.m16714b()) {
            new AsyncTaskC4371h(this, i).execute(this.f15924g);
        }
    }

    /* renamed from: c */
    public void m16707c(int i) {
        new AsyncTaskC4371h(this, i).execute(new C4396av(this, null));
    }

    /* renamed from: a */
    public void m16703a(int i, String str, String str2) {
        new AsyncTaskC4371h(this, i).execute(new C4402ba(this, str2, null));
    }

    /* renamed from: f */
    public boolean m16711f() {
        return this.f15924g != null && this.f15924g.m16714b();
    }
}
