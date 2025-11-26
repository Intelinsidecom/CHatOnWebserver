package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AbstractC4370g;
import p021c.C0351j;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bo */
/* loaded from: classes.dex */
class C4416bo extends AbstractC4370g {

    /* renamed from: d */
    String f15968d;

    /* renamed from: e */
    final /* synthetic */ C4410bi f15969e;

    /* synthetic */ C4416bo(C4410bi c4410bi, String str, HandlerC4411bj handlerC4411bj) {
        this(c4410bi, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4416bo(C4410bi c4410bi, String str) {
        super(c4410bi, "InviteMessageTask");
        this.f15969e = c4410bi;
        this.f15968d = null;
        this.f15968d = str;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message = null;
        try {
            C4410bi.f15957d.m1231b(this.f15968d);
        } catch (C0351j e) {
            e.printStackTrace();
            this.f15835a = -1005;
            message = e.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
