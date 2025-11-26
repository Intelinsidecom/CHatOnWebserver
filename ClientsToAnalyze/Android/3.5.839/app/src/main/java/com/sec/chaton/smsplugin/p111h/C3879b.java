package com.sec.chaton.smsplugin.p111h;

import com.sec.chaton.multimedia.audio.C2723a;

/* compiled from: AudioEffector.java */
/* renamed from: com.sec.chaton.smsplugin.h.b */
/* loaded from: classes.dex */
public class C3879b {

    /* renamed from: a */
    private static C2723a f13970a;

    /* renamed from: a */
    public static void m14961a(boolean z, boolean z2) {
        if (z) {
            if (f13970a != null && !z2) {
                f13970a.m11426a("TRANS_FAIL");
                return;
            }
            return;
        }
        if (f13970a != null && z2) {
            f13970a.m11426a("RECV_SUCC");
        }
    }
}
