package com.sec.chaton.sns.p115ui;

import com.sec.chaton.R;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.ah */
/* loaded from: classes.dex */
class C4454ah implements InterfaceC4442z {

    /* renamed from: a */
    final /* synthetic */ SnsSubMenuFragment f16097a;

    C4454ah(SnsSubMenuFragment snsSubMenuFragment) {
        this.f16097a = snsSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9438a(int i) {
        C4904y.m18634a("onError get friend list", SnsSubMenuFragment.f16050g);
        if (this.f16097a.f16057h != null) {
            if (this.f16097a.f16051a != null) {
                this.f16097a.f16051a.setVisibility(8);
            }
            this.f16097a.m16918e();
            this.f16097a.m16921h();
            this.f16097a.f16052b.setVisibility(0);
            this.f16097a.m16914a(false);
        }
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9439a(ArrayList<C4379ae> arrayList) {
        if (this.f16097a.f16057h != null) {
            this.f16097a.f16054d.addAll(AbstractC4439w.m16817a(arrayList));
            this.f16097a.f16064o.setText(this.f16097a.getString(R.string.chat_info_invite) + " (" + this.f16097a.f16054d.size() + ")");
            if (this.f16097a.f16051a != null) {
                this.f16097a.f16051a.setVisibility(8);
            }
            if (this.f16097a.f16054d == null || this.f16097a.f16054d.size() == 0) {
                C4904y.m18639b("friends.size() == 0 || friends == null", SnsSubMenuFragment.f16050g);
                this.f16097a.f16052b.setVisibility(0);
            } else {
                C4904y.m18639b("friends.size() != 0 || friends != null", SnsSubMenuFragment.f16050g);
                this.f16097a.f16053c.notifyDataSetChanged();
            }
            this.f16097a.m16914a(false);
        }
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4442z
    /* renamed from: a */
    public void mo9437a() {
        if (this.f16097a.f16057h != null) {
            C4904y.m18639b("onCancelled get friend list", getClass().getSimpleName());
            if (this.f16097a.f16051a != null) {
                this.f16097a.f16051a.setVisibility(8);
            }
            this.f16097a.f16052b.setVisibility(0);
            this.f16097a.m16914a(false);
        }
    }
}
