package com.sec.chaton.push.heartbeat;

import android.content.SharedPreferences;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;

/* compiled from: HeartBeat.java */
/* renamed from: com.sec.chaton.push.heartbeat.b */
/* loaded from: classes.dex */
final class C0906b implements InterfaceC0898j {
    C0906b() {
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3531a() {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f3081c) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(HeartBeat.f3079a, "Success send ping.");
                }
                if (HeartBeat.f3082d == EnumC0918d.Mobile) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(HeartBeat.f3079a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m3592t()) {
                        if (C0921g.f3116a) {
                            C0921g.m3637a(HeartBeat.f3079a, "Ping interval is expired. Reset fail count.");
                        }
                        int unused = HeartBeat.f3084f = 0;
                        SharedPreferences.Editor editorM3538a = C0904h.m3538a();
                        C0904h.m3558d(editorM3538a, HeartBeat.m3593u());
                        C0904h.m3541a(editorM3538a, HeartBeat.f3084f);
                        editorM3538a.commit();
                    }
                }
                HeartBeat.m3574b(true);
                HeartBeat.m3590r();
            }
        }
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3532a(int i) {
        synchronized (HeartBeat.class) {
            if (HeartBeat.f3081c) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(HeartBeat.f3079a, "Fail send ping.");
                    C0921g.m3642d(HeartBeat.f3079a, String.format("Ping error code is %d. Decrease ping interval.", Integer.valueOf(i)));
                }
                if (HeartBeat.f3082d == EnumC0918d.Mobile) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(HeartBeat.f3079a, "Check ping interval expired.");
                    }
                    if (HeartBeat.m3592t()) {
                        if (C0921g.f3116a) {
                            C0921g.m3637a(HeartBeat.f3079a, "Ping interval is expired.");
                        }
                        SharedPreferences.Editor editorM3538a = C0904h.m3538a();
                        C0904h.m3558d(editorM3538a, HeartBeat.m3593u());
                        editorM3538a.commit();
                    }
                }
                HeartBeat.m3574b(false);
                HeartBeat.m3590r();
            }
        }
    }
}
