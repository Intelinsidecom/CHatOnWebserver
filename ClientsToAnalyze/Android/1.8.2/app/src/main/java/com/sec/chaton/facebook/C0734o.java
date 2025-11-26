package com.sec.chaton.facebook;

import android.os.Bundle;
import com.p001a.p002a.C0036k;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.settings.tellfriends.C1350ae;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.o */
/* loaded from: classes.dex */
class C0734o extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2726a;

    /* synthetic */ C0734o(C0725f c0725f, HandlerC0726g handlerC0726g) {
        this(c0725f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0734o(C0725f c0725f) {
        super(c0725f, "GetMyInfo");
        this.f2726a = c0725f;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        if (m3229a("me", new Bundle(), "GET", "email") == -1) {
            C0036k.m33b(this.f2726a.f2703c, this.f2710c);
        }
        int iA = m3229a("me", new Bundle(), "GET", "id");
        if (iA == -1) {
            C0036k.m30a(this.f2726a.f2703c, this.f2710c);
        }
        new C0633e(this.f2726a.f2702a).m2862a(C1350ae.f5157a, this.f2726a.m3216a());
        return iA;
    }
}
