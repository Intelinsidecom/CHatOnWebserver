package com.sec.chaton.registration;

import com.sec.chaton.p025d.EnumC1313az;
import com.sec.chaton.p025d.InterfaceC1316bb;

/* compiled from: FragmentConnectAccounts.java */
/* renamed from: com.sec.chaton.registration.bp */
/* loaded from: classes.dex */
class C2165bp implements InterfaceC1316bb {

    /* renamed from: a */
    final /* synthetic */ FragmentConnectAccounts f8450a;

    C2165bp(FragmentConnectAccounts fragmentConnectAccounts) {
        this.f8450a = fragmentConnectAccounts;
    }

    @Override // com.sec.chaton.p025d.InterfaceC1316bb
    /* renamed from: a */
    public void mo5670a(int i, EnumC1313az enumC1313az) {
        switch (i) {
            case 1301:
                this.f8450a.f8201h.runOnUiThread(new RunnableC2168bs(this));
                break;
            case 1302:
                this.f8450a.f8201h.runOnUiThread(new RunnableC2167br(this));
                break;
            case 1303:
                this.f8450a.f8201h.runOnUiThread(new RunnableC2166bq(this));
                break;
        }
    }
}
