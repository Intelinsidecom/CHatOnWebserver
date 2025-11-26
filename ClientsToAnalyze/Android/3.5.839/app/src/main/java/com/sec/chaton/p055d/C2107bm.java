package com.sec.chaton.p055d;

import com.sec.chaton.sns.p113a.C4364a;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.bm */
/* loaded from: classes.dex */
class C2107bm implements InterfaceC4442z {

    /* renamed from: a */
    final /* synthetic */ C2105bk f7655a;

    C2107bm(C2105bk c2105bk) {
        this.f7655a = c2105bk;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9439a(ArrayList<C4379ae> arrayList) {
        C4904y.m18639b("onComplete get friend list " + arrayList.size(), getClass().getSimpleName());
        if (arrayList == null || arrayList.size() < 0) {
            this.f7655a.m9398a(1301);
            return;
        }
        this.f7655a.f7646j.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                if (!this.f7655a.f7648l.equals(C4368e.f15815a)) {
                    this.f7655a.f7646j.add(new C4364a(arrayList.get(i2).m16625a(), arrayList.get(i2).m16631f(), arrayList.get(i2).m16628c()));
                } else if (arrayList.get(i2).m16630e()) {
                    this.f7655a.f7646j.add(new C4364a(arrayList.get(i2).m16625a(), arrayList.get(i2).m16631f(), arrayList.get(i2).m16628c()));
                }
                i = i2 + 1;
            } else {
                this.f7655a.f7650n = this.f7655a.m9423r();
                C4904y.m18639b("snsBuddies  " + this.f7655a.f7650n, getClass().getSimpleName());
                this.f7655a.m9419n();
                return;
            }
        }
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9437a() {
        C4904y.m18639b("onCancelled get friend list", getClass().getSimpleName());
        this.f7655a.m9398a(1303);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9438a(int i) {
        C4904y.m18639b("onError get friend list error code: " + i, getClass().getSimpleName());
        if (i == 1307) {
            this.f7655a.m9398a(1307);
        } else {
            this.f7655a.m9398a(1302);
        }
    }
}
