package com.facebook;

import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: Request.java */
/* renamed from: com.facebook.aq */
/* loaded from: classes.dex */
class C0076aq implements InterfaceC0080au {

    /* renamed from: a */
    final /* synthetic */ ArrayList f128a;

    /* renamed from: b */
    final /* synthetic */ C0072am f129b;

    C0076aq(C0072am c0072am, ArrayList arrayList) {
        this.f129b = c0072am;
        this.f128a = arrayList;
    }

    @Override // com.facebook.InterfaceC0080au
    /* renamed from: a */
    public void mo177a(String str, String str2) {
        this.f128a.add(String.format("%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
    }
}
