package com.sec.chaton.msgsend;

/* compiled from: MsgSendResultCode.java */
/* renamed from: com.sec.chaton.msgsend.w */
/* loaded from: classes.dex */
public class C1763w {

    /* renamed from: a */
    public int f6494a = -1;

    /* renamed from: b */
    public int f6495b = -1;

    /* renamed from: c */
    EnumC1762v f6496c;

    public C1763w(EnumC1762v enumC1762v) {
        this.f6496c = enumC1762v;
    }

    public String toString() {
        return String.format("[Result : %s, Req %d/Total %d]", this.f6496c, Integer.valueOf(this.f6495b), Integer.valueOf(this.f6494a));
    }
}
