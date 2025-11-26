package com.sec.chaton;

import com.sec.chaton.account.C0239h;
import com.sec.chaton.util.C1296as;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.e */
/* loaded from: classes.dex */
class C0673e implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2321a;

    C0673e(HomeActivity homeActivity) {
        this.f2321a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() {
        if (!C1323bs.m4575a().contains("uid")) {
            return false;
        }
        C0239h.m911b("uploadAddress");
        C1296as.m4519a(true);
        return true;
    }
}
