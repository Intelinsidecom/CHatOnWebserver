package com.facebook;

import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.f */
/* loaded from: classes.dex */
class C0532f implements InterfaceC0448ar {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1336a;

    /* renamed from: b */
    final /* synthetic */ C0502c f1337b;

    C0532f(C0502c c0502c, ArrayList arrayList) {
        this.f1337b = c0502c;
        this.f1336a = arrayList;
    }

    @Override // com.facebook.InterfaceC0448ar
    /* renamed from: a */
    public void mo1620a(C0456az c0456az) {
        GraphObjectList<GraphObject> data;
        try {
            GraphMultiResult graphMultiResult = (GraphMultiResult) c0456az.m1660a(GraphMultiResult.class);
            if (graphMultiResult != null && (data = graphMultiResult.getData()) != null && data.size() == 1) {
                this.f1336a.addAll(data.get(0).asMap().keySet());
            }
        } catch (Exception e) {
        }
    }
}
