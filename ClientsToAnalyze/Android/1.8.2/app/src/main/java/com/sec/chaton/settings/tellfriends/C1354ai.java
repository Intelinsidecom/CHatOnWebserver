package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ai */
/* loaded from: classes.dex */
class C1354ai implements InterfaceC1368aw {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5171a;

    C1354ai(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5171a = snsFriendsUsingChatOnActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: a */
    public void mo5087a(ArrayList arrayList) {
        C1786r.m6061b("onComplete get friend list", getClass().getSimpleName());
        this.f5171a.f5008z = arrayList;
        if (this.f5171a.f5008z.size() != 0 && this.f5171a.f5008z != null) {
            this.f5171a.f4990h.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f5171a.f5008z.size()) {
                    if (((C1373ba) this.f5171a.f5008z.get(i2)).f5206e) {
                        this.f5171a.f4990h.add(new C1342a(((C1373ba) this.f5171a.f5008z.get(i2)).f5202a, ((C1373ba) this.f5171a.f5008z.get(i2)).f5203b, ((C1373ba) this.f5171a.f5008z.get(i2)).f5204c));
                    }
                    i = i2 + 1;
                } else {
                    this.f5171a.f4994l = this.f5171a.m4848e();
                    this.f5171a.m4846d();
                    return;
                }
            }
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: a */
    public void mo5086a() {
        C1786r.m6061b("onCancelled get friend list", getClass().getSimpleName());
        this.f5171a.m4857j();
        this.f5171a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: b */
    public void mo5088b() {
        this.f5171a.m4861l();
        this.f5171a.m4866n();
    }
}
