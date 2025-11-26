package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.facebook.C0431aa;
import com.facebook.C0551y;
import com.facebook.p033c.InterfaceC0526w;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.f */
/* loaded from: classes.dex */
class C4422f implements InterfaceC0526w {

    /* renamed from: a */
    final /* synthetic */ C4374a f15977a;

    C4422f(C4374a c4374a) {
        this.f15977a = c4374a;
    }

    @Override // com.facebook.p033c.InterfaceC0526w
    /* renamed from: a */
    public void mo1908a(Bundle bundle, C0551y c0551y) {
        if (c0551y == null) {
            if (bundle.getString(VKApiConst.POST_ID) != null) {
                this.f15977a.f15848d.mo16563a(1, -1, null);
                return;
            } else {
                this.f15977a.f15848d.mo16563a(1, DlcApi.RC_SVC_NOT_CONNECTED, null);
                return;
            }
        }
        if (c0551y instanceof C0431aa) {
            this.f15977a.f15848d.mo16563a(1, 0, c0551y);
        } else {
            this.f15977a.f15848d.mo16563a(1, DlcApi.RC_SVC_NOT_CONNECTED, c0551y);
        }
    }
}
