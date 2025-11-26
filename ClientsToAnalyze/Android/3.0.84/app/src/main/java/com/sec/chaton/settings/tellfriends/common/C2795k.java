package com.sec.chaton.settings.tellfriends.common;

import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.k */
/* loaded from: classes.dex */
class C2795k implements InterfaceC2727ad {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsPickerFragment f10290a;

    C2795k(SnsFriendsPickerFragment snsFriendsPickerFragment) {
        this.f10290a = snsFriendsPickerFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5655a(ArrayList<C2732ai> arrayList) {
        C3250y.m11450b("onComplete get friend list", getClass().getSimpleName());
        if (arrayList == null || arrayList.size() <= 0) {
            this.f10290a.m9953i();
            return;
        }
        Iterator<C2732ai> it = arrayList.iterator();
        while (it.hasNext()) {
            C2732ai next = it.next();
            if (this.f10290a.m9944e() != EnumC2798n.FACEBOOK_TYPE) {
                this.f10290a.f10232n.add(next);
            } else if (next.m9788e()) {
                this.f10290a.f10232n.add(next);
            }
        }
        this.f10290a.f10221c = this.f10290a.m9935a((ArrayList<C2732ai>) this.f10290a.f10232n);
        this.f10290a.m9932a(this.f10290a.f10221c);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5653a() {
        C3250y.m11450b("onCancelled get friend list", getClass().getSimpleName());
        this.f10290a.m9953i();
        this.f10290a.f10222d.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5654a(int i) {
        this.f10290a.m9956k();
        this.f10290a.m9960m();
    }
}
