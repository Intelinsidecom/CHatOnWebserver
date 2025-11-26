package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.AbstractC0164c;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.a.n */
/* loaded from: classes.dex */
public class C0215n {

    /* renamed from: a */
    private ArrayList f521a;

    /* renamed from: b */
    private Handler f522b;

    /* renamed from: c */
    private Handler f523c;

    /* renamed from: d */
    private int f524d;

    /* renamed from: e */
    private C0505l f525e;

    /* renamed from: f */
    private long f526f;

    public C0215n(Handler handler, C0505l c0505l) {
        this.f524d = 0;
        this.f521a = new ArrayList();
        this.f523c = handler;
        this.f525e = c0505l;
        this.f526f = C1325bu.m4591a();
        m786a(new HandlerC0214m(this, handler.getLooper()));
    }

    public C0215n(Handler handler, C0505l c0505l, long j) {
        this.f524d = 0;
        this.f521a = new ArrayList();
        this.f523c = handler;
        this.f525e = c0505l;
        this.f526f = j;
        m786a(new HandlerC0214m(this, handler.getLooper()));
    }

    /* renamed from: a */
    public long m785a() {
        return this.f526f;
    }

    /* renamed from: a */
    public void m786a(Handler handler) {
        this.f522b = handler;
    }

    /* renamed from: b */
    public Handler m788b() {
        return this.f522b;
    }

    /* renamed from: a */
    public boolean m787a(EnumC0206e enumC0206e, Object obj) {
        C1341p.m4658b("AddTaskToList : " + String.valueOf(enumC0206e.m775a()), "TaskContainer");
        return this.f521a.add(new C0199al(this, enumC0206e, obj));
    }

    /* renamed from: c */
    public Object m789c() {
        C0199al c0199al = (C0199al) this.f521a.get(this.f524d);
        if (c0199al == null) {
            return null;
        }
        return c0199al.m750b();
    }

    /* renamed from: d */
    public boolean m790d() {
        if (this.f521a.size() == 0 || this.f524d >= this.f521a.size()) {
            return false;
        }
        C0199al c0199al = (C0199al) this.f521a.get(this.f524d);
        switch (c0199al.m749a()) {
            case HttpTask:
                C0512s.m2577a().offer((AbstractRunnableC0153bb) c0199al.m750b());
                return true;
            case NetTask:
                ((AbstractC0164c) c0199al.m750b()).m702a(this.f525e);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public boolean m791e() {
        this.f524d++;
        if (this.f524d < this.f521a.size()) {
            return true;
        }
        return false;
    }
}
