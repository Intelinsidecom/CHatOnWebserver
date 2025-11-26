package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p015d.p016a.AbstractC0559b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.am */
/* loaded from: classes.dex */
public class C0623am {

    /* renamed from: a */
    private ArrayList f2442a;

    /* renamed from: b */
    private Handler f2443b;

    /* renamed from: c */
    private Handler f2444c;

    /* renamed from: d */
    private int f2445d;

    /* renamed from: e */
    private C0816z f2446e;

    /* renamed from: f */
    private long f2447f;

    /* renamed from: g */
    private long f2448g;

    public C0623am(Handler handler, C0816z c0816z) {
        this.f2445d = 0;
        this.f2442a = new ArrayList();
        this.f2444c = handler;
        this.f2446e = c0816z;
        this.f2447f = C1735ar.m5918a();
        m2819a(new HandlerC0625ao(this, handler.getLooper()));
    }

    public C0623am(Handler handler, C0816z c0816z, long j) {
        this.f2445d = 0;
        this.f2442a = new ArrayList();
        this.f2444c = handler;
        this.f2446e = c0816z;
        this.f2448g = j;
        m2819a(new HandlerC0625ao(this, handler.getLooper()));
    }

    /* renamed from: a */
    public long m2818a() {
        return this.f2447f;
    }

    /* renamed from: b */
    public long m2821b() {
        return this.f2448g;
    }

    /* renamed from: a */
    public void m2819a(Handler handler) {
        this.f2443b = handler;
    }

    /* renamed from: c */
    public Handler m2822c() {
        return this.f2443b;
    }

    /* renamed from: a */
    public boolean m2820a(EnumC0627aq enumC0627aq, Object obj) {
        C1786r.m6061b("AddTaskToList : " + String.valueOf(enumC0627aq.m2828a()), "TaskContainer");
        return this.f2442a.add(new C0626ap(this, enumC0627aq, obj));
    }

    /* renamed from: d */
    public Object m2823d() {
        C0626ap c0626ap = (C0626ap) this.f2442a.get(this.f2445d);
        if (c0626ap == null) {
            return null;
        }
        return c0626ap.m2827b();
    }

    /* renamed from: e */
    public boolean m2824e() {
        if (this.f2442a.size() == 0 || this.f2445d >= this.f2442a.size()) {
            return false;
        }
        C0626ap c0626ap = (C0626ap) this.f2442a.get(this.f2445d);
        switch (c0626ap.m2826a()) {
            case HttpTask:
                C0802l.m3412a().offer((AbstractRunnableC0532a) c0626ap.m2827b());
                return true;
            case NetTask:
                ((AbstractC0559b) c0626ap.m2827b()).m2757a(this.f2446e);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: f */
    public boolean m2825f() {
        this.f2445d++;
        if (this.f2445d < this.f2442a.size()) {
            return true;
        }
        return false;
    }
}
