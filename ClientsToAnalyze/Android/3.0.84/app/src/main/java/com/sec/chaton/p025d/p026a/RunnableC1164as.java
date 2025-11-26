package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.util.C3250y;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.as */
/* loaded from: classes.dex */
class RunnableC1164as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1455w f4616a;

    /* renamed from: b */
    final /* synthetic */ long f4617b;

    /* renamed from: c */
    final /* synthetic */ Handler f4618c;

    /* renamed from: d */
    final /* synthetic */ String f4619d;

    /* renamed from: e */
    final /* synthetic */ String f4620e;

    /* renamed from: f */
    final /* synthetic */ EnumC1450r f4621f;

    /* renamed from: g */
    final /* synthetic */ String f4622g;

    /* renamed from: h */
    final /* synthetic */ String f4623h;

    /* renamed from: i */
    final /* synthetic */ String f4624i;

    /* renamed from: j */
    final /* synthetic */ C1162aq f4625j;

    RunnableC1164as(C1162aq c1162aq, EnumC1455w enumC1455w, long j, Handler handler, String str, String str2, EnumC1450r enumC1450r, String str3, String str4, String str5) {
        this.f4625j = c1162aq;
        this.f4616a = enumC1455w;
        this.f4617b = j;
        this.f4618c = handler;
        this.f4619d = str;
        this.f4620e = str2;
        this.f4621f = enumC1450r;
        this.f4622g = str3;
        this.f4623h = str4;
        this.f4624i = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4616a == EnumC1455w.IMAGE || this.f4616a == EnumC1455w.AMS) {
            if (!C1555a.m6596a().m6599a(this.f4617b, true)) {
                C1555a.m6596a().m6597a(null, null, this.f4618c, 0, this.f4619d, true, this.f4620e, this.f4617b, this.f4616a, this.f4621f, this.f4622g);
            }
        } else if (C1770b.m7289a().m7304b(this.f4620e) && !C1555a.m6596a().m6598a(this.f4617b)) {
            C1555a.m6596a().m6597a(null, null, this.f4618c, 0, this.f4619d, false, this.f4620e, this.f4617b, this.f4616a, this.f4621f, this.f4622g);
        }
        C3250y.m11450b("[Download (URL)] " + this.f4623h, getClass().getName());
        C3250y.m11450b("[Download (FileName)] " + this.f4624i, getClass().getName());
    }
}
