package com.facebook;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.l */
/* loaded from: classes.dex */
class C0167l extends AbstractC0164i {

    /* renamed from: b */
    final /* synthetic */ C0131c f381b;

    /* renamed from: c */
    private transient ServiceConnectionC0066ag f382c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0167l(C0131c c0131c) {
        super(c0131c);
        this.f381b = c0131c;
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: c */
    void mo478c() {
        if (this.f382c != null) {
            this.f382c.m123b();
            this.f382c = null;
        }
    }

    @Override // com.facebook.AbstractC0164i
    /* renamed from: a */
    boolean mo476a(C0165j c0165j) {
        this.f382c = new ServiceConnectionC0066ag(this.f381b.f283c, c0165j.m485f());
        if (this.f382c.m122a()) {
            this.f381b.m384h();
            this.f382c.m121a(new C0168m(this, c0165j));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    void m491a(C0165j c0165j, Bundle bundle) {
        this.f382c = null;
        this.f381b.m385i();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            List<String> listM481b = c0165j.m481b();
            if (stringArrayList != null && (listM481b == null || stringArrayList.containsAll(listM481b))) {
                this.f381b.m391a(C0173r.m493a(C0053a.m80a(bundle, EnumC0086b.FACEBOOK_APPLICATION_SERVICE)));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : listM481b) {
                if (!stringArrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
            c0165j.m480a(arrayList);
        }
        this.f381b.m400d();
    }
}
