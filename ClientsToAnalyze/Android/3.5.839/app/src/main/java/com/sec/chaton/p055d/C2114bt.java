package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p055d.p056a.AbstractC1927b;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.bt */
/* loaded from: classes.dex */
public class C2114bt {

    /* renamed from: a */
    private ArrayList<C2117bw> f7678a;

    /* renamed from: b */
    private Handler f7679b;

    /* renamed from: c */
    private Handler f7680c;

    /* renamed from: d */
    private int f7681d;

    /* renamed from: e */
    private C2422ak f7682e;

    /* renamed from: f */
    private long f7683f;

    /* renamed from: e */
    static /* synthetic */ int m9451e(C2114bt c2114bt) {
        int i = c2114bt.f7681d;
        c2114bt.f7681d = i + 1;
        return i;
    }

    public C2114bt(Handler handler, C2422ak c2422ak) {
        this.f7681d = 0;
        this.f7678a = new ArrayList<>();
        this.f7680c = handler;
        this.f7682e = c2422ak;
        this.f7683f = C4843bh.m18322a();
        m9453a(new HandlerC2116bv(this, handler.getLooper()));
    }

    public C2114bt(Handler handler, C2422ak c2422ak, long j) {
        this.f7681d = 0;
        this.f7678a = new ArrayList<>();
        this.f7680c = handler;
        this.f7682e = c2422ak;
        this.f7683f = j;
        m9453a(new HandlerC2116bv(this, handler.getLooper()));
    }

    /* renamed from: a */
    public long m9452a() {
        return this.f7683f;
    }

    /* renamed from: a */
    public void m9453a(Handler handler) {
        this.f7679b = handler;
    }

    /* renamed from: b */
    public Handler m9455b() {
        return this.f7679b;
    }

    /* renamed from: a */
    public boolean m9454a(EnumC2118bx enumC2118bx, AbstractC1927b abstractC1927b) {
        C4904y.m18639b("AddTaskToList : " + String.valueOf(enumC2118bx.m9462a()), "TaskContainer");
        return this.f7678a.add(new C2117bw(this, enumC2118bx, abstractC1927b));
    }

    /* renamed from: c */
    public Object m9456c() {
        C2117bw c2117bw = this.f7678a.get(this.f7681d);
        if (c2117bw == null) {
            return null;
        }
        return c2117bw.m9461b();
    }

    /* renamed from: d */
    public boolean m9457d() {
        if (this.f7678a.size() == 0 || this.f7681d >= this.f7678a.size()) {
            return false;
        }
        C2117bw c2117bw = this.f7678a.get(this.f7681d);
        switch (c2117bw.m9460a()) {
            case HttpTask:
                C2472w.m10687a().m10690b().m10661a((AbstractC1900a) c2117bw.m9461b());
                return true;
            case NetTask:
                ((AbstractC1927b) c2117bw.m9461b()).m9103a(this.f7682e);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public boolean m9458e() {
        if (this.f7681d + 1 < this.f7678a.size()) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public void m9459f() {
        this.f7681d++;
    }
}
