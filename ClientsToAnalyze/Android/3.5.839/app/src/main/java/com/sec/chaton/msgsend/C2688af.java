package com.sec.chaton.msgsend;

/* compiled from: MsgSendResultCode.java */
/* renamed from: com.sec.chaton.msgsend.af */
/* loaded from: classes.dex */
public class C2688af {

    /* renamed from: a */
    public int f9644a = -1;

    /* renamed from: b */
    public int f9645b = -1;

    /* renamed from: c */
    EnumC2687ae f9646c;

    public C2688af(EnumC2687ae enumC2687ae) {
        this.f9646c = enumC2687ae;
    }

    public String toString() {
        return String.format("[Result : %s, Req %d/Total %d]", this.f9646c, Integer.valueOf(this.f9645b), Integer.valueOf(this.f9644a));
    }
}
