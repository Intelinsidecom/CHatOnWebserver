package com.sec.chaton.sns.p114b;

import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.chaton.sns.p113a.C4368e;
import p021c.C0346e;
import p021c.C0351j;
import p021c.p022a.C0326a;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bm */
/* loaded from: classes.dex */
class C4414bm extends AbstractC4370g {

    /* renamed from: d */
    C0326a f15965d;

    /* renamed from: e */
    final /* synthetic */ C4410bi f15966e;

    /* synthetic */ C4414bm(C4410bi c4410bi, C0326a c0326a, HandlerC4411bj handlerC4411bj) {
        this(c4410bi, c0326a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4414bm(C4410bi c4410bi, C0326a c0326a) {
        super(c4410bi, "GetMyInfoTask");
        this.f15966e = c4410bi;
        this.f15965d = c0326a;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        this.f15966e.m16571a("GetMyInfoTask() : Get my name");
        String message = null;
        try {
            C0346e c0346eM1226a = C4410bi.f15957d.m1226a(String.valueOf(this.f15965d.m1119a()));
            if (c0346eM1226a != null) {
                C4445e.m16843b(this.f15966e.f15830a, String.valueOf(this.f15965d.m1119a()));
                C4445e.m16839a(this.f15966e.f15830a, c0346eM1226a.m1218b());
                C4445e.m16845c(this.f15966e.f15830a, c0346eM1226a.m1220d().toString());
            }
            C0326a c0326aM1224a = C4410bi.f15957d.m1224a();
            if (c0326aM1224a != null) {
                C4445e.m16847d(this.f15966e.f15830a, c0326aM1224a.m1121b());
            }
            new C2128i(this.f15966e.f15959f).m9500a(C4368e.f15816b, C4445e.m16846d(this.f15966e.f15830a));
            this.f15835a = -1;
        } catch (C0351j e) {
            e.printStackTrace();
            this.f15835a = -1005;
            message = e.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
