package com.sec.chaton.facebook;

import android.os.Bundle;
import com.p001a.p002a.C0037b;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.l */
/* loaded from: classes.dex */
class C0697l extends AbstractC0701p {

    /* renamed from: a */
    final /* synthetic */ C0700o f2371a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0697l(C0700o c0700o) {
        super(c0700o, "GetMyInfo");
        this.f2371a = c0700o;
    }

    @Override // com.sec.chaton.facebook.AbstractC0701p
    /* renamed from: a */
    protected int mo3065a() {
        int iA = m3088a("me", new Bundle(), "GET", "email");
        if (iA == -1) {
            C0037b.m11a(this.f2371a.f2376b, this.f2380c);
        }
        return iA;
    }
}
