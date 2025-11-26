package com.sec.chaton.buddy;

import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ch */
/* loaded from: classes.dex */
class C0577ch implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2539a;

    C0577ch(BuddyFragment buddyFragment) {
        this.f2539a = buddyFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() throws UnsupportedEncodingException {
        C3250y.m11450b("mGetAllBuddiesTaskInBuddylist run [UID] " + C3159aa.m10962a().m10987b("uid") + " [MSISDN] " + C3159aa.m10962a().m10979a("msisdn", ""), BuddyFragment.f1724a);
        if (C3159aa.m10962a().m10987b("uid")) {
            new C1330h(null).m5717a();
            new C1330h(null).m5736c();
            if (this.f2539a.f1743G == null) {
                this.f2539a.f1743G = new C1345w(this.f2539a.f1876cl);
            }
            this.f2539a.f1743G.m5936c(null);
        }
        C3250y.m11450b("mGetAllBuddiesTaskInBuddylist finish", BuddyFragment.f1724a);
        return true;
    }
}
