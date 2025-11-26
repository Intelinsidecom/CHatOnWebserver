package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import java.util.ArrayList;
import p021c.C0336b;
import p021c.C0351j;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bk */
/* loaded from: classes.dex */
class C4412bk extends AbstractC4370g {

    /* renamed from: d */
    ArrayList<Long> f15961d;

    /* renamed from: e */
    final /* synthetic */ C4410bi f15962e;

    /* synthetic */ C4412bk(C4410bi c4410bi, HandlerC4411bj handlerC4411bj) {
        this(c4410bi);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4412bk(C4410bi c4410bi) {
        super(c4410bi, "GetFriendsIDsTask");
        this.f15962e = c4410bi;
        this.f15961d = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message;
        int iM1178b = -1;
        try {
            String strM16846d = C4445e.m16846d(this.f15962e.f15830a);
            do {
                C0336b c0336bM1230b = C4410bi.f15957d.m1230b(strM16846d, iM1178b, 5000);
                for (long j : c0336bM1230b.m1177a()) {
                    this.f15961d.add(Long.valueOf(j));
                }
                iM1178b = (int) c0336bM1230b.m1178b();
            } while (iM1178b != 0);
            long[] jArr = new long[this.f15961d.size()];
            for (int i = 0; i < this.f15961d.size(); i++) {
                jArr[i] = this.f15961d.get(i).longValue();
            }
            this.f15835a = -1;
            message = jArr;
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
