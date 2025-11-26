package com.sec.chaton.p013a.p014a;

import com.sec.chaton.p033io.entry.inner.Msg;
import java.util.ArrayList;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.a.a.j */
/* loaded from: classes.dex */
public class C0171j {

    /* renamed from: a */
    final /* synthetic */ C0181t f407a;

    /* renamed from: b */
    private String f408b;

    /* renamed from: c */
    private boolean f409c;

    /* renamed from: d */
    private ArrayList f410d = new ArrayList();

    /* renamed from: e */
    private ArrayList f411e = new ArrayList();

    /* renamed from: f */
    private int f412f = 0;

    public C0171j(C0181t c0181t, String str, boolean z) {
        this.f407a = c0181t;
        this.f408b = str;
        this.f409c = z;
    }

    /* renamed from: a */
    public String m708a() {
        return this.f408b;
    }

    /* renamed from: b */
    public boolean m711b() {
        return this.f409c;
    }

    /* renamed from: c */
    public ArrayList m712c() {
        return this.f410d;
    }

    /* renamed from: d */
    public ArrayList m713d() {
        return this.f411e;
    }

    /* renamed from: a */
    public void m710a(Msg msg) {
        if (msg.type.equals("noti")) {
            this.f411e.add(msg);
        } else {
            this.f410d.add(msg);
        }
    }

    /* renamed from: e */
    public int m714e() {
        return this.f412f;
    }

    /* renamed from: a */
    public void m709a(int i) {
        this.f412f = i;
    }
}
