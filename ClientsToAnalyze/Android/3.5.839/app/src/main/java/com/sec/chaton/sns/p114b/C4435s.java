package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.renren.android.C0724f;
import com.renren.android.p041b.C0711a;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.s */
/* loaded from: classes.dex */
class C4435s extends C4438v {

    /* renamed from: d */
    final /* synthetic */ C4432p f16007d;

    /* renamed from: e */
    private String[] f16008e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4435s(C4432p c4432p) {
        super(c4432p, "GetFriendsListTask");
        this.f16007d = c4432p;
        this.f16008e = new String[]{"tinyurl_with_logo"};
    }

    @Override // com.sec.chaton.sns.p114b.C4438v, com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        Bundle bundleM2265a = null;
        C0711a c0711a = new C0711a();
        c0711a.m2266a(this.f16008e);
        try {
            bundleM2265a = c0711a.m2265a();
        } catch (C0724f e) {
            e.printStackTrace();
        }
        return m16814a(bundleM2265a);
    }
}
