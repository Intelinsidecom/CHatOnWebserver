package com.facebook;

import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.g */
/* loaded from: classes.dex */
class C0533g implements InterfaceC0455ay {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1338a;

    /* renamed from: b */
    final /* synthetic */ C0544r f1339b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f1340c;

    /* renamed from: d */
    final /* synthetic */ C0502c f1341d;

    C0533g(C0502c c0502c, ArrayList arrayList, C0544r c0544r, ArrayList arrayList2) {
        this.f1341d = c0502c;
        this.f1338a = arrayList;
        this.f1339b = c0544r;
        this.f1340c = arrayList2;
    }

    @Override // com.facebook.InterfaceC0455ay
    /* renamed from: a */
    public void mo1653a(C0454ax c0454ax) {
        C0502c c0502c;
        C0544r c0544rM1938a;
        try {
            try {
                if (this.f1338a.size() == 2 && this.f1338a.get(0) != null && this.f1338a.get(1) != null && ((String) this.f1338a.get(0)).equals(this.f1338a.get(1))) {
                    c0544rM1938a = C0544r.m1936a(C0424a.m1525a(this.f1339b.f1359b, this.f1340c));
                } else {
                    c0544rM1938a = C0544r.m1938a("User logged in as different Facebook user.", null);
                }
                this.f1341d.m1837b(c0544rM1938a);
                c0502c = this.f1341d;
            } catch (Exception e) {
                this.f1341d.m1837b(C0544r.m1938a("Caught exception", e.getMessage()));
                c0502c = this.f1341d;
            }
            c0502c.m1828i();
        } catch (Throwable th) {
            this.f1341d.m1828i();
            throw th;
        }
    }
}
