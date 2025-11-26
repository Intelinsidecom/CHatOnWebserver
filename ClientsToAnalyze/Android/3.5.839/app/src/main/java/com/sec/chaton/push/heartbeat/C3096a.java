package com.sec.chaton.push.heartbeat;

import android.content.SharedPreferences;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.a */
/* loaded from: classes.dex */
final class C3096a implements InterfaceC3081b {
    C3096a() {
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12558a() {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f11412c) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(HeartBeat.f11410a, "Success send ping.");
                }
                if (HeartBeat.f11413d == EnumC3114f.Mobile) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(HeartBeat.f11410a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m12623r()) {
                        if (C3115g.f11458a) {
                            C3115g.m12701a(HeartBeat.f11410a, "Ping interval is expired. Reset fail count.");
                        }
                        int unused = HeartBeat.f11414e = 0;
                        SharedPreferences.Editor editorM12627a = C3099k.m12627a();
                        C3099k.m12643c(editorM12627a, HeartBeat.m12624s());
                        C3099k.m12631a(editorM12627a, HeartBeat.f11414e);
                        editorM12627a.commit();
                    }
                }
                HeartBeat.m12607b(true);
                HeartBeat.m12621p();
            }
        }
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12559a(int i) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f11412c) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(HeartBeat.f11410a, "Fail send ping.");
                    C3115g.m12706d(HeartBeat.f11410a, String.format("Ping error code is %d. Decrease ping interval.", Integer.valueOf(i)));
                }
                if (HeartBeat.f11413d == EnumC3114f.Mobile) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(HeartBeat.f11410a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m12623r()) {
                        if (C3115g.f11458a) {
                            C3115g.m12701a(HeartBeat.f11410a, "Ping interval is expired.");
                        }
                        SharedPreferences.Editor editorM12627a = C3099k.m12627a();
                        C3099k.m12643c(editorM12627a, HeartBeat.m12624s());
                        editorM12627a.commit();
                    }
                }
                HeartBeat.m12607b(false);
                HeartBeat.m12621p();
            }
        }
    }
}
