package com.sec.chaton.msgsend;

import android.os.SystemClock;
import com.sec.chaton.p051c.C1433g;

/* compiled from: MsgRequestBlockManager.java */
/* renamed from: com.sec.chaton.msgsend.u */
/* loaded from: classes.dex */
class C2713u {

    /* renamed from: a */
    final EnumC2714v f9719a;

    /* renamed from: b */
    long f9720b;

    /* renamed from: c */
    long f9721c;

    /* renamed from: d */
    final /* synthetic */ C2711s f9722d;

    public C2713u(C2711s c2711s, EnumC2714v enumC2714v) {
        this.f9722d = c2711s;
        m11361c();
        this.f9719a = enumC2714v;
    }

    /* renamed from: a */
    long m11358a() {
        return this.f9721c;
    }

    /* renamed from: b */
    long m11360b() {
        switch (this.f9719a) {
            case RELEASE_ALLOWCHAT:
                return C1433g.m7529c() * 2;
            case RELEASE_INITCHAT:
                return C1433g.m7531e() * 2;
            case RELEASE_SERIALCHAT:
                return C1433g.m7530d() * 2;
            default:
                return C1433g.m7530d() * 2;
        }
    }

    /* renamed from: c */
    void m11361c() {
        this.f9720b = -1L;
        this.f9721c = -1L;
    }

    /* renamed from: a */
    void m11359a(long j) {
        m11361c();
        this.f9720b = SystemClock.uptimeMillis();
        this.f9721c = j;
    }

    /* renamed from: d */
    boolean m11362d() {
        if (SystemClock.uptimeMillis() - this.f9720b <= m11360b()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    EnumC2715w m11363e() {
        if (this.f9721c > 0) {
            if (m11362d()) {
                return EnumC2715w.REQUEST_TIMEOUT;
            }
            return EnumC2715w.REQUEST_IN_PROGRESS;
        }
        return EnumC2715w.REQUEST_IDLE;
    }

    public String toString() {
        return "[" + this.f9719a + "] mStartTimeStamp: " + this.f9720b + ", mMessageId: " + this.f9721c;
    }
}
