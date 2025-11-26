package com.facebook;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.l */
/* loaded from: classes.dex */
class C0538l extends AbstractC0535i {

    /* renamed from: b */
    final /* synthetic */ C0502c f1351b;

    /* renamed from: c */
    private transient ServiceConnectionC0437ag f1352c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0538l(C0502c c0502c) {
        super(c0502c);
        this.f1351b = c0502c;
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: c */
    void mo1921c() {
        if (this.f1352c != null) {
            this.f1352c.m1567b();
            this.f1352c = null;
        }
    }

    @Override // com.facebook.AbstractC0535i
    /* renamed from: a */
    boolean mo1919a(C0536j c0536j) {
        this.f1352c = new ServiceConnectionC0437ag(this.f1351b.f1252c, c0536j.m1928f());
        if (this.f1352c.m1566a()) {
            this.f1351b.m1827h();
            this.f1352c.m1565a(new C0539m(this, c0536j));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    void m1934a(C0536j c0536j, Bundle bundle) {
        this.f1352c = null;
        this.f1351b.m1828i();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            List<String> listM1924b = c0536j.m1924b();
            if (stringArrayList != null && (listM1924b == null || stringArrayList.containsAll(listM1924b))) {
                this.f1351b.m1834a(C0544r.m1936a(C0424a.m1523a(bundle, EnumC0457b.FACEBOOK_APPLICATION_SERVICE)));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : listM1924b) {
                if (!stringArrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
            c0536j.m1923a(arrayList);
        }
        this.f1351b.m1843d();
    }
}
