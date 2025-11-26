package com.sds.coolots.call.consent.acceptor;

/* renamed from: com.sds.coolots.call.consent.acceptor.c */
/* loaded from: classes.dex */
public class C1153c implements AutoAcceptorInterface {

    /* renamed from: a */
    private final int f2357a;

    /* renamed from: b */
    private final int f2358b;

    public C1153c(int i, int i2) {
        this.f2357a = i;
        this.f2358b = i2;
    }

    @Override // com.sds.coolots.call.consent.acceptor.AutoAcceptorInterface
    public boolean isAcceptCompareWithCurrentOption(int i, int i2) {
        return i == i2;
    }

    @Override // com.sds.coolots.call.consent.acceptor.AutoAcceptorInterface
    public boolean isAcceptDuplicationRequest(int i, int i2) {
        return this.f2357a == i && this.f2358b == i2;
    }
}
