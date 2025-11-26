package com.sec.chaton.smsplugin.p102b;

import android.os.Handler;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.common.CommonApplication;

/* compiled from: WorkingMessage.java */
/* renamed from: com.sec.chaton.smsplugin.b.v */
/* loaded from: classes.dex */
class RunnableC3803v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3790i f13661a;

    /* renamed from: b */
    final /* synthetic */ String f13662b;

    /* renamed from: c */
    final /* synthetic */ boolean f13663c;

    /* renamed from: d */
    final /* synthetic */ C3799r f13664d;

    RunnableC3803v(C3799r c3799r, C3790i c3790i, String str, boolean z) {
        this.f13664d = c3799r;
        this.f13661a = c3790i;
        this.f13662b = str;
        this.f13663c = z;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        try {
            C3887j.m14982c().m14987a(true);
            this.f13661a.m14360e();
            this.f13661a.m14356b(true);
            this.f13664d.m14418b(this.f13661a, this.f13662b);
            if (C3887j.m14982c() == null) {
                C3887j.m14979a(CommonApplication.m18732r());
            }
            C3887j.m14982c().m14987a(false);
            if (this.f13663c) {
                C3811d.m14485a("asyncUpdateDraftSmsMessage MsgboxSync.SYNC_SMS_VIA_BYPASS", new Object[0]);
                C2654bs.m11169a().m11187a(3, (Handler) null);
            }
        } catch (Throwable th) {
            if (C3887j.m14982c() == null) {
                C3887j.m14979a(CommonApplication.m18732r());
            }
            C3887j.m14982c().m14987a(false);
            throw th;
        }
    }
}
