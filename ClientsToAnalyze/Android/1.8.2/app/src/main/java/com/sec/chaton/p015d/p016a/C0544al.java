package com.sec.chaton.p015d.p016a;

import com.sec.chaton.p028io.entry.inner.Msg;
import java.util.ArrayList;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.al */
/* loaded from: classes.dex */
public class C0544al {

    /* renamed from: a */
    final /* synthetic */ C0541ai f2213a;

    /* renamed from: b */
    private String f2214b;

    /* renamed from: c */
    private boolean f2215c;

    /* renamed from: d */
    private ArrayList f2216d = new ArrayList();

    /* renamed from: e */
    private ArrayList f2217e = new ArrayList();

    /* renamed from: f */
    private int f2218f = 0;

    public C0544al(C0541ai c0541ai, String str, boolean z) {
        this.f2213a = c0541ai;
        this.f2214b = str;
        this.f2215c = z;
    }

    /* renamed from: a */
    public boolean m2741a() {
        return this.f2215c;
    }

    /* renamed from: b */
    public ArrayList m2742b() {
        return this.f2216d;
    }

    /* renamed from: c */
    public ArrayList m2743c() {
        return this.f2217e;
    }

    /* renamed from: a */
    public void m2740a(Msg msg) {
        if (msg.type.equals("noti")) {
            this.f2217e.add(msg);
        } else {
            this.f2216d.add(msg);
        }
    }

    /* renamed from: d */
    public int m2744d() {
        return this.f2218f;
    }

    /* renamed from: a */
    public void m2739a(int i) {
        this.f2218f = i;
    }
}
