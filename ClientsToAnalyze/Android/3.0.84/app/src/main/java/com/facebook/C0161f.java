package com.facebook;

import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.f */
/* loaded from: classes.dex */
class C0161f implements InterfaceC0077ar {

    /* renamed from: a */
    final /* synthetic */ ArrayList f366a;

    /* renamed from: b */
    final /* synthetic */ C0131c f367b;

    C0161f(C0131c c0131c, ArrayList arrayList) {
        this.f367b = c0131c;
        this.f366a = arrayList;
    }

    @Override // com.facebook.InterfaceC0077ar
    /* renamed from: a */
    public void mo176a(C0085az c0085az) {
        GraphObjectList<GraphObject> data;
        try {
            GraphMultiResult graphMultiResult = (GraphMultiResult) c0085az.m216a(GraphMultiResult.class);
            if (graphMultiResult != null && (data = graphMultiResult.getData()) != null && data.size() == 1) {
                this.f366a.addAll(data.get(0).asMap().keySet());
            }
        } catch (Exception e) {
        }
    }
}
