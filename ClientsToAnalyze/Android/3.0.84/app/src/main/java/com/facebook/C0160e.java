package com.facebook;

import com.facebook.model.GraphUser;
import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.e */
/* loaded from: classes.dex */
class C0160e implements InterfaceC0077ar {

    /* renamed from: a */
    final /* synthetic */ ArrayList f364a;

    /* renamed from: b */
    final /* synthetic */ C0131c f365b;

    C0160e(C0131c c0131c, ArrayList arrayList) {
        this.f365b = c0131c;
        this.f364a = arrayList;
    }

    @Override // com.facebook.InterfaceC0077ar
    /* renamed from: a */
    public void mo176a(C0085az c0085az) {
        try {
            GraphUser graphUser = (GraphUser) c0085az.m216a(GraphUser.class);
            if (graphUser != null) {
                this.f364a.add(graphUser.getId());
            }
        } catch (Exception e) {
        }
    }
}
