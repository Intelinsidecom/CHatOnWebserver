package com.sec.chaton.sns.p115ui;

import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.sns.ui.x */
/* loaded from: classes.dex */
class C4521x implements InterfaceC4442z {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsPickerFragment f16277a;

    C4521x(SnsFriendsPickerFragment snsFriendsPickerFragment) {
        this.f16277a = snsFriendsPickerFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9439a(ArrayList<C4379ae> arrayList) {
        C4904y.m18639b("onComplete get friend list", getClass().getSimpleName());
        if (arrayList == null || arrayList.size() <= 0) {
            this.f16277a.m16877i();
            return;
        }
        Iterator<C4379ae> it = arrayList.iterator();
        while (it.hasNext()) {
            C4379ae next = it.next();
            if (this.f16277a.m16868e() != EnumC4447aa.FACEBOOK_TYPE) {
                this.f16277a.f16034s.add(next);
            } else if (next.m16630e()) {
                this.f16277a.f16034s.add(next);
            }
        }
        this.f16277a.f16018c = this.f16277a.m16859a((ArrayList<C4379ae>) this.f16277a.f16034s);
        this.f16277a.m16856a(this.f16277a.f16018c);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9437a() {
        C4904y.m18639b("onCancelled get friend list", getClass().getSimpleName());
        this.f16277a.m16877i();
        this.f16277a.f16019d.finish();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9438a(int i) {
        this.f16277a.m16880k();
        this.f16277a.m16884m();
    }
}
