package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import java.util.ArrayList;
import java.util.Iterator;
import p021c.C0346e;
import p021c.C0347f;
import p021c.C0351j;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bl */
/* loaded from: classes.dex */
class C4413bl extends AbstractC4370g {

    /* renamed from: d */
    final /* synthetic */ C4410bi f15963d;

    /* renamed from: e */
    private long f15964e;

    /* synthetic */ C4413bl(C4410bi c4410bi, HandlerC4411bj handlerC4411bj) {
        this(c4410bi);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4413bl(C4410bi c4410bi) {
        super(c4410bi, "GetFriendsListTask");
        this.f15963d = c4410bi;
        this.f15964e = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message;
        long jM1222b;
        try {
            String strM16846d = C4445e.m16846d(this.f15963d.f15830a);
            ArrayList arrayList = new ArrayList();
            do {
                C0347f c0347fM1227a = C4410bi.f15957d.m1227a(strM16846d, (int) this.f15964e, 5000);
                Iterator<C0346e> it = c0347fM1227a.m1221a().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                jM1222b = c0347fM1227a.m1222b();
                this.f15964e = jM1222b;
            } while (jM1222b != 0);
            this.f15835a = -1;
            message = arrayList;
        } catch (C0351j e) {
            e.printStackTrace();
            this.f15835a = -1005;
            message = e.getMessage();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            this.f15835a = -1005;
            message = e2.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
