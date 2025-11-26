package com.facebook;

import java.util.ArrayList;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.g */
/* loaded from: classes.dex */
class C0162g implements InterfaceC0084ay {

    /* renamed from: a */
    final /* synthetic */ ArrayList f368a;

    /* renamed from: b */
    final /* synthetic */ C0173r f369b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f370c;

    /* renamed from: d */
    final /* synthetic */ C0131c f371d;

    C0162g(C0131c c0131c, ArrayList arrayList, C0173r c0173r, ArrayList arrayList2) {
        this.f371d = c0131c;
        this.f368a = arrayList;
        this.f369b = c0173r;
        this.f370c = arrayList2;
    }

    @Override // com.facebook.InterfaceC0084ay
    /* renamed from: a */
    public void mo209a(C0083ax c0083ax) {
        C0131c c0131c;
        C0173r c0173rM495a;
        try {
            try {
                if (this.f368a.size() == 2 && this.f368a.get(0) != null && this.f368a.get(1) != null && ((String) this.f368a.get(0)).equals(this.f368a.get(1))) {
                    c0173rM495a = C0173r.m493a(C0053a.m82a(this.f369b.f389b, this.f370c));
                } else {
                    c0173rM495a = C0173r.m495a("User logged in as different Facebook user.", null);
                }
                this.f371d.m394b(c0173rM495a);
                c0131c = this.f371d;
            } catch (Exception e) {
                this.f371d.m394b(C0173r.m495a("Caught exception", e.getMessage()));
                c0131c = this.f371d;
            }
            c0131c.m385i();
        } catch (Throwable th) {
            this.f371d.m385i();
            throw th;
        }
    }
}
