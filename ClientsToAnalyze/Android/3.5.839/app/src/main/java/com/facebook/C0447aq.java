package com.facebook;

import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: Request.java */
/* renamed from: com.facebook.aq */
/* loaded from: classes.dex */
class C0447aq implements InterfaceC0451au {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1097a;

    /* renamed from: b */
    final /* synthetic */ C0443am f1098b;

    C0447aq(C0443am c0443am, ArrayList arrayList) {
        this.f1098b = c0443am;
        this.f1097a = arrayList;
    }

    @Override // com.facebook.InterfaceC0451au
    /* renamed from: a */
    public void mo1621a(String str, String str2) {
        this.f1097a.add(String.format("%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
    }
}
