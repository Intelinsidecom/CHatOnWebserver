package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0495d;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;

/* compiled from: AbstractHttpTask2.java */
/* renamed from: com.sec.chaton.a.a.bb */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0153bb implements Runnable {

    /* renamed from: a */
    private String f364a = null;

    /* renamed from: b */
    private int f365b = 0;

    /* renamed from: c */
    protected final C0503j f366c;

    /* renamed from: d */
    protected Message f367d;

    /* renamed from: e */
    protected Handler f368e;

    /* renamed from: a */
    public abstract String mo670a();

    /* renamed from: a */
    public abstract void mo671a(C0259g c0259g);

    public AbstractRunnableC0153bb(Handler handler, C0503j c0503j) {
        this.f368e = null;
        this.f366c = c0503j;
        this.f368e = handler;
    }

    /* renamed from: c */
    public final void m685c() {
        this.f365b = 1;
    }

    /* renamed from: d */
    public final void m686d() {
        this.f365b = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f367d = new Message();
        C0259g c0259g = new C0259g(this.f366c);
        c0259g.m923a(EnumC0518y.ERROR);
        this.f367d.what = this.f366c.m2534g();
        try {
            this.f364a = mo670a();
            if (this.f365b == 0) {
                C0495d.m2498a(c0259g, this.f364a);
            } else {
                c0259g.m923a(EnumC0518y.NO_REQUEST);
            }
            if (c0259g.m936h() == 401) {
                C0512s.m2577a().clear();
                if (!ExitAppDialogActivity.m624a()) {
                    ExitAppDialogActivity.m625b();
                    return;
                }
                return;
            }
            if (this.f365b != 2) {
                mo671a(c0259g);
                if (this.f368e != null) {
                    this.f367d.obj = c0259g;
                    this.f368e.sendMessage(this.f367d);
                }
            }
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            if (this.f368e != null && this.f365b != 2) {
                this.f367d.obj = c0259g;
                this.f368e.sendMessage(this.f367d);
            }
        }
    }

    /* renamed from: e */
    public C0259g m687e() {
        C0259g c0259g = new C0259g(this.f366c);
        c0259g.m923a(EnumC0518y.ERROR);
        try {
            this.f364a = mo670a();
            if (this.f365b == 0) {
                C0495d.m2498a(c0259g, this.f364a);
            } else {
                c0259g.m923a(EnumC0518y.NO_REQUEST);
            }
            if (this.f365b != 2) {
                mo671a(c0259g);
            }
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
        return c0259g;
    }
}
