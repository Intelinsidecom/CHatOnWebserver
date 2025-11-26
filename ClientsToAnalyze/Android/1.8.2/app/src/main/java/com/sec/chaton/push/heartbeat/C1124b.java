package com.sec.chaton.push.heartbeat;

import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.receiver.InterfaceC1131b;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.b */
/* loaded from: classes.dex */
final class C1124b implements InterfaceC1131b {
    C1124b() {
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC1131b
    /* renamed from: a */
    public void mo4238a(String str) {
        synchronized (HeartBeat.class) {
            if (C1139g.f4142a) {
                C1139g.m4308a(HeartBeat.f4095a, "HeartBeat.onNetworkOperatorChangedListener()");
            }
            if (HeartBeat.f4098d == EnumC1138f.Mobile && str != null && str.length() != 0) {
                if (str.equals(C1126j.m4268h((String) null))) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(HeartBeat.f4095a, "Saved network operator == New newtork operator.");
                    }
                } else {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(HeartBeat.f4095a, String.format("Network operator is changed from %s to %s.", HeartBeat.f4099e, str));
                    }
                    String unused = HeartBeat.f4099e = str;
                    HeartBeat.m4233o();
                    HeartBeat.m4221c();
                }
            }
        }
    }
}
