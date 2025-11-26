package com.sec.chaton.facebook;

import android.os.Bundle;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.n */
/* loaded from: classes.dex */
class C0733n extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2725a;

    /* synthetic */ C0733n(C0725f c0725f, HandlerC0726g handlerC0726g) {
        this(c0725f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0733n(C0725f c0725f) {
        super(c0725f, "GetFriends");
        this.f2725a = c0725f;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "name,installed");
        return m3229a("me/friends", bundle, "GET", "data");
    }
}
