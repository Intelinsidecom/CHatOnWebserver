package com.sds.coolots.call.consent.acceptor;

/* renamed from: com.sds.coolots.call.consent.acceptor.a */
/* loaded from: classes.dex */
public class C1151a implements AutoAcceptorInterface {

    /* renamed from: a */
    private final int f2355a;

    /* renamed from: b */
    private final int f2356b;

    public C1151a(int i, int i2) {
        this.f2355a = i;
        this.f2356b = i2;
    }

    @Override // com.sds.coolots.call.consent.acceptor.AutoAcceptorInterface
    public boolean isAcceptCompareWithCurrentOption(int i, int i2) {
        return false;
    }

    @Override // com.sds.coolots.call.consent.acceptor.AutoAcceptorInterface
    public boolean isAcceptDuplicationRequest(int i, int i2) {
        return false;
    }
}
