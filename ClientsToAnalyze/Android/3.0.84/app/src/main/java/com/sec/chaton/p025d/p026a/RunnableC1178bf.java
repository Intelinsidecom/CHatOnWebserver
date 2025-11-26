package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.util.C3250y;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.bf */
/* loaded from: classes.dex */
class RunnableC1178bf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1455w f4658a;

    /* renamed from: b */
    final /* synthetic */ String f4659b;

    /* renamed from: c */
    final /* synthetic */ String f4660c;

    /* renamed from: d */
    final /* synthetic */ String f4661d;

    /* renamed from: e */
    final /* synthetic */ String f4662e;

    /* renamed from: f */
    final /* synthetic */ long f4663f;

    /* renamed from: g */
    final /* synthetic */ EnumC1450r f4664g;

    /* renamed from: h */
    final /* synthetic */ String f4665h;

    /* renamed from: i */
    final /* synthetic */ Handler f4666i;

    /* renamed from: j */
    final /* synthetic */ String f4667j;

    /* renamed from: k */
    final /* synthetic */ C1176bd f4668k;

    RunnableC1178bf(C1176bd c1176bd, EnumC1455w enumC1455w, String str, String str2, String str3, String str4, long j, EnumC1450r enumC1450r, String str5, Handler handler, String str6) {
        this.f4668k = c1176bd;
        this.f4658a = enumC1455w;
        this.f4659b = str;
        this.f4660c = str2;
        this.f4661d = str3;
        this.f4662e = str4;
        this.f4663f = j;
        this.f4664g = enumC1450r;
        this.f4665h = str5;
        this.f4666i = handler;
        this.f4667j = str6;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4658a == EnumC1455w.IMAGE || this.f4658a == EnumC1455w.AMS) {
            new AsyncTaskC1170ay(this.f4659b, this.f4660c, this.f4661d, true, this.f4662e, this.f4663f, this.f4664g, this.f4665h).execute(new String[0]);
        } else if (C1770b.m7289a().m7304b(this.f4662e) && !C1555a.m6596a().m6598a(this.f4663f)) {
            C1555a.m6596a().m6597a(null, null, this.f4666i, 0, this.f4667j, false, this.f4662e, this.f4663f, this.f4658a, this.f4664g, this.f4665h);
        }
        C3250y.m11450b("[Download (URL)] " + this.f4659b, getClass().getName());
        C3250y.m11450b("[Download (FileName)] " + this.f4661d, getClass().getName());
    }
}
