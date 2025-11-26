package com.sec.chaton.p031g;

import android.os.Bundle;
import com.facebook.C0060aa;
import com.facebook.C0180y;
import com.facebook.p009c.InterfaceC0155w;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.f */
/* loaded from: classes.dex */
class C1488f implements InterfaceC0155w {

    /* renamed from: a */
    final /* synthetic */ C1483a f5502a;

    C1488f(C1483a c1483a) {
        this.f5502a = c1483a;
    }

    @Override // com.facebook.p009c.InterfaceC0155w
    /* renamed from: a */
    public void mo465a(Bundle bundle, C0180y c0180y) {
        if (c0180y == null) {
            if (bundle.getString("post_id") != null) {
                this.f5502a.f5493d.mo9799a(1, -1, null);
                return;
            } else {
                this.f5502a.f5493d.mo9799a(1, DlcApi.RC_SVC_NOT_CONNECTED, null);
                return;
            }
        }
        if (c0180y instanceof C0060aa) {
            this.f5502a.f5493d.mo9799a(1, 0, c0180y);
        } else {
            this.f5502a.f5493d.mo9799a(1, DlcApi.RC_SVC_NOT_CONNECTED, c0180y);
        }
    }
}
