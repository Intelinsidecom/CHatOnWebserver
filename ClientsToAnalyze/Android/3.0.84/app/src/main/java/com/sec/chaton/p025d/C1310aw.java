package com.sec.chaton.p025d;

import com.sec.chaton.settings.tellfriends.C2723a;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.settings.tellfriends.C2831y;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.aw */
/* loaded from: classes.dex */
class C1310aw implements InterfaceC2727ad {

    /* renamed from: a */
    final /* synthetic */ C1308au f4957a;

    C1310aw(C1308au c1308au) {
        this.f4957a = c1308au;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5655a(ArrayList<C2732ai> arrayList) {
        C3250y.m11450b("onComplete get friend list", getClass().getSimpleName());
        if (arrayList == null || arrayList.size() <= 0) {
            this.f4957a.m5622a(1301);
            return;
        }
        this.f4957a.f4950i.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                if (!this.f4957a.f4952k.equals(C2831y.f10362a)) {
                    this.f4957a.f4950i.add(new C2723a(arrayList.get(i2).m9783a(), arrayList.get(i2).m9789f(), arrayList.get(i2).m9786c()));
                } else if (arrayList.get(i2).m9788e()) {
                    this.f4957a.f4950i.add(new C2723a(arrayList.get(i2).m9783a(), arrayList.get(i2).m9789f(), arrayList.get(i2).m9786c()));
                }
                i = i2 + 1;
            } else {
                this.f4957a.f4953l = this.f4957a.m5647n();
                this.f4957a.m5643j();
                return;
            }
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5653a() {
        C3250y.m11450b("onCancelled get friend list", getClass().getSimpleName());
        this.f4957a.m5622a(1303);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5654a(int i) {
        C3250y.m11450b("onError get friend list", getClass().getSimpleName());
        this.f4957a.m5622a(1302);
    }
}
