package com.sec.chaton.settings.tellfriends;

import android.os.Bundle;
import com.renren.android.C0212f;
import com.renren.android.p011b.C0199a;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.p */
/* loaded from: classes.dex */
class C2822p extends C2825s {

    /* renamed from: a */
    final /* synthetic */ C2819m f10350a;

    /* renamed from: b */
    private String[] f10351b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2822p(C2819m c2819m) {
        super(c2819m, "GetFriendsListTask");
        this.f10350a = c2819m;
        this.f10351b = new String[]{"tinyurl_with_logo"};
    }

    @Override // com.sec.chaton.settings.tellfriends.C2825s, com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        Bundle bundleM533a = null;
        C0199a c0199a = new C0199a();
        c0199a.m534a(this.f10351b);
        try {
            bundleM533a = c0199a.m533a();
        } catch (C0212f e) {
            e.printStackTrace();
        }
        return m10056a(bundleM533a);
    }
}
