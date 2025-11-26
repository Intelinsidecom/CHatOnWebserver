package com.sec.chaton.push.heartbeat;

import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.receiver.InterfaceC0912a;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.a */
/* loaded from: classes.dex */
final class C0905a implements InterfaceC0912a {
    C0905a() {
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC0912a
    /* renamed from: a */
    public void mo3594a(String str) {
        synchronized (HeartBeat.class) {
            if (C0921g.f3116a) {
                C0921g.m3637a(HeartBeat.f3079a, "HeartBeat.onNetworkOperatorChangedListener()");
            }
            if (HeartBeat.f3082d == EnumC0918d.Mobile && str != null && str.length() != 0) {
                if (str.equals(C0904h.m3566h((String) null))) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(HeartBeat.f3079a, "Saved network operator == New newtork operator.");
                    }
                } else {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(HeartBeat.f3079a, String.format("Network operator is changed from %s to %s.", HeartBeat.f3083e, str));
                    }
                    String unused = HeartBeat.f3083e = str;
                    HeartBeat.m3589q();
                    HeartBeat.m3577e();
                }
            }
        }
    }
}
