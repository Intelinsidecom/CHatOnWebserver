package com.sec.chaton.facebook;

import android.os.Bundle;
import com.facebook.android.SessionStore;

/* renamed from: com.sec.chaton.facebook.k */
/* loaded from: classes.dex */
class C0229k extends AbstractC0231m {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1861a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0229k(FacebookManager facebookManager) {
        super(facebookManager, "GetMyInfo");
        this.f1861a = facebookManager;
    }

    @Override // com.sec.chaton.facebook.AbstractC0231m
    /* renamed from: a */
    protected int mo2365a() {
        int iA = m2370a("me", new Bundle(), "GET", "email");
        if (iA == -1) {
            SessionStore.m255a(this.f1861a.f1837b, this.f1867c);
        }
        return iA;
    }
}
