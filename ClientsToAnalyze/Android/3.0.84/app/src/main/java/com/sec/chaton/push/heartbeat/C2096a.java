package com.sec.chaton.push.heartbeat;

import android.content.SharedPreferences;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.a */
/* loaded from: classes.dex */
final class C2096a implements InterfaceC2081b {
    C2096a() {
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8215a() {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f8002c) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(HeartBeat.f8000a, "Success send ping.");
                }
                if (HeartBeat.f8003d == EnumC2114f.Mobile) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(HeartBeat.f8000a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m8280r()) {
                        if (C2115g.f8048a) {
                            C2115g.m8359a(HeartBeat.f8000a, "Ping interval is expired. Reset fail count.");
                        }
                        int unused = HeartBeat.f8004e = 0;
                        SharedPreferences.Editor editorM8284a = C2099k.m8284a();
                        C2099k.m8304d(editorM8284a, HeartBeat.m8281s());
                        C2099k.m8288a(editorM8284a, HeartBeat.f8004e);
                        editorM8284a.commit();
                    }
                }
                HeartBeat.m8264b(true);
                HeartBeat.m8278p();
            }
        }
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8216a(int i) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f8002c) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(HeartBeat.f8000a, "Fail send ping.");
                    C2115g.m8364d(HeartBeat.f8000a, String.format("Ping error code is %d. Decrease ping interval.", Integer.valueOf(i)));
                }
                if (HeartBeat.f8003d == EnumC2114f.Mobile) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(HeartBeat.f8000a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m8280r()) {
                        if (C2115g.f8048a) {
                            C2115g.m8359a(HeartBeat.f8000a, "Ping interval is expired.");
                        }
                        SharedPreferences.Editor editorM8284a = C2099k.m8284a();
                        C2099k.m8304d(editorM8284a, HeartBeat.m8281s());
                        editorM8284a.commit();
                    }
                }
                HeartBeat.m8264b(false);
                HeartBeat.m8278p();
            }
        }
    }
}
