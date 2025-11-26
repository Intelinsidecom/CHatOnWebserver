package com.sec.chaton.settings.tellfriends.common;

import com.sec.chaton.R;
import com.sec.chaton.settings.tellfriends.AbstractC2724aa;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.y */
/* loaded from: classes.dex */
class C2809y implements InterfaceC2727ad {

    /* renamed from: a */
    final /* synthetic */ SnsSubMenuFragment f10322a;

    C2809y(SnsSubMenuFragment snsSubMenuFragment) {
        this.f10322a = snsSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5654a(int i) {
        C3250y.m11442a("onError get friend list", SnsSubMenuFragment.f10248g);
        if (this.f10322a.f10255h != null) {
            if (this.f10322a.f10249a != null) {
                this.f10322a.f10249a.setVisibility(8);
            }
            this.f10322a.m9990g();
            this.f10322a.m9993j();
            this.f10322a.f10250b.setVisibility(0);
            this.f10322a.m9987a(false);
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5655a(ArrayList<C2732ai> arrayList) {
        if (this.f10322a.f10255h != null) {
            this.f10322a.f10252d.addAll(AbstractC2724aa.m9765a(arrayList));
            this.f10322a.f10262o.setText(this.f10322a.getString(R.string.chat_info_invite) + " (" + this.f10322a.f10252d.size() + ")");
            if (this.f10322a.f10249a != null) {
                this.f10322a.f10249a.setVisibility(8);
            }
            if (this.f10322a.f10252d == null || this.f10322a.f10252d.size() == 0) {
                C3250y.m11450b("friends.size() == 0 || friends == null", SnsSubMenuFragment.f10248g);
                this.f10322a.f10250b.setVisibility(0);
            } else {
                C3250y.m11450b("friends.size() != 0 || friends != null", SnsSubMenuFragment.f10248g);
                this.f10322a.f10251c.notifyDataSetChanged();
            }
            this.f10322a.m9987a(false);
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2727ad
    /* renamed from: a */
    public void mo5653a() {
        if (this.f10322a.f10255h != null) {
            C3250y.m11450b("onCancelled get friend list", getClass().getSimpleName());
            if (this.f10322a.f10249a != null) {
                this.f10322a.f10249a.setVisibility(8);
            }
            this.f10322a.f10250b.setVisibility(0);
            this.f10322a.m9987a(false);
        }
    }
}
