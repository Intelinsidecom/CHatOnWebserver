package com.facebook;

import com.facebook.model.GraphUser;
import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.e */
/* loaded from: classes.dex */
class C0531e implements InterfaceC0448ar {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1334a;

    /* renamed from: b */
    final /* synthetic */ C0502c f1335b;

    C0531e(C0502c c0502c, ArrayList arrayList) {
        this.f1335b = c0502c;
        this.f1334a = arrayList;
    }

    @Override // com.facebook.InterfaceC0448ar
    /* renamed from: a */
    public void mo1620a(C0456az c0456az) {
        try {
            GraphUser graphUser = (GraphUser) c0456az.m1660a(GraphUser.class);
            if (graphUser != null) {
                this.f1334a.add(graphUser.getId());
            }
        } catch (Exception e) {
        }
    }
}
