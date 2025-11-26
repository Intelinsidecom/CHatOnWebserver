package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p065io.entry.inner.Msg;
import java.util.ArrayList;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bl */
/* loaded from: classes.dex */
public class C1939bl {

    /* renamed from: a */
    final /* synthetic */ C1937bj f7229a;

    /* renamed from: b */
    private String f7230b;

    /* renamed from: c */
    private boolean f7231c;

    /* renamed from: d */
    private ArrayList<Msg> f7232d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<Msg> f7233e = new ArrayList<>();

    /* renamed from: f */
    private int f7234f = 0;

    /* renamed from: g */
    private Msg f7235g;

    public C1939bl(C1937bj c1937bj, String str, boolean z) {
        this.f7229a = c1937bj;
        this.f7230b = str;
        this.f7231c = z;
    }

    /* renamed from: a */
    public String m9122a() {
        return this.f7230b;
    }

    /* renamed from: b */
    public ArrayList<Msg> m9125b() {
        return this.f7232d;
    }

    /* renamed from: c */
    public ArrayList<Msg> m9126c() {
        return this.f7233e;
    }

    /* renamed from: a */
    public void m9124a(Msg msg) {
        if (msg.type.equals("noti")) {
            this.f7233e.add(msg);
        } else {
            this.f7232d.add(msg);
        }
    }

    /* renamed from: d */
    public int m9127d() {
        return this.f7234f;
    }

    /* renamed from: a */
    public void m9123a(int i) {
        this.f7234f = i;
    }

    /* renamed from: e */
    public Msg m9128e() {
        return this.f7235g;
    }
}
