package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p035io.entry.inner.Msg;
import java.util.ArrayList;

/* compiled from: GetAllUnReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bj */
/* loaded from: classes.dex */
public class C1182bj {

    /* renamed from: a */
    final /* synthetic */ C1179bg f4677a;

    /* renamed from: b */
    private String f4678b;

    /* renamed from: c */
    private boolean f4679c;

    /* renamed from: d */
    private ArrayList<Msg> f4680d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<Msg> f4681e = new ArrayList<>();

    /* renamed from: f */
    private int f4682f = 0;

    public C1182bj(C1179bg c1179bg, String str, boolean z) {
        this.f4677a = c1179bg;
        this.f4678b = str;
        this.f4679c = z;
    }

    /* renamed from: a */
    public String m5531a() {
        return this.f4678b;
    }

    /* renamed from: b */
    public ArrayList<Msg> m5534b() {
        return this.f4680d;
    }

    /* renamed from: c */
    public ArrayList<Msg> m5535c() {
        return this.f4681e;
    }

    /* renamed from: a */
    public void m5533a(Msg msg) {
        if (msg.type.equals("noti")) {
            this.f4681e.add(msg);
        } else {
            this.f4680d.add(msg);
        }
    }

    /* renamed from: d */
    public int m5536d() {
        return this.f4682f;
    }

    /* renamed from: a */
    public void m5532a(int i) {
        this.f4682f = i;
    }
}
