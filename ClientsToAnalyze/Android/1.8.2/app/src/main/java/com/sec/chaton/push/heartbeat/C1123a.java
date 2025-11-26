package com.sec.chaton.push.heartbeat;

import android.content.SharedPreferences;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.a */
/* loaded from: classes.dex */
final class C1123a implements InterfaceC1108b {
    C1123a() {
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4170a() {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f4097c) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(HeartBeat.f4095a, "Success send ping.");
                }
                if (HeartBeat.f4098d == EnumC1138f.Mobile) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(HeartBeat.f4095a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m4236r()) {
                        if (C1139g.f4142a) {
                            C1139g.m4308a(HeartBeat.f4095a, "Ping interval is expired. Reset fail count.");
                        }
                        int unused = HeartBeat.f4100f = 0;
                        SharedPreferences.Editor editorM4240a = C1126j.m4240a();
                        C1126j.m4260d(editorM4240a, HeartBeat.m4237s());
                        C1126j.m4243a(editorM4240a, HeartBeat.f4100f);
                        editorM4240a.commit();
                    }
                }
                HeartBeat.m4219b(true);
                HeartBeat.m4234p();
            }
        }
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4171a(int i) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f4097c) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(HeartBeat.f4095a, "Fail send ping.");
                    C1139g.m4313d(HeartBeat.f4095a, String.format("Ping error code is %d. Decrease ping interval.", Integer.valueOf(i)));
                }
                if (HeartBeat.f4098d == EnumC1138f.Mobile) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(HeartBeat.f4095a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m4236r()) {
                        if (C1139g.f4142a) {
                            C1139g.m4308a(HeartBeat.f4095a, "Ping interval is expired.");
                        }
                        SharedPreferences.Editor editorM4240a = C1126j.m4240a();
                        C1126j.m4260d(editorM4240a, HeartBeat.m4237s());
                        editorM4240a.commit();
                    }
                }
                HeartBeat.m4219b(false);
                HeartBeat.m4234p();
            }
        }
    }
}
