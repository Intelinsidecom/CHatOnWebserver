package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AbstractC4370g;
import p021c.C0351j;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bp */
/* loaded from: classes.dex */
class C4417bp extends AbstractC4370g {

    /* renamed from: d */
    String f15970d;

    /* renamed from: e */
    final /* synthetic */ C4410bi f15971e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4417bp(C4410bi c4410bi, String str) {
        super(c4410bi, "RevokeOAuth2Task");
        this.f15971e = c4410bi;
        this.f15970d = str;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        Object message;
        try {
            message = Boolean.valueOf(C4410bi.f15957d.m1236d(this.f15970d));
        } catch (C0351j e) {
            e.printStackTrace();
            this.f15835a = -1005;
            message = e.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
