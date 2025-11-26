package com.sec.chaton.p067j;

import android.os.Handler;
import com.sec.chaton.msgsend.C2717y;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.q */
/* loaded from: classes.dex */
public class C2466q {

    /* renamed from: a */
    final Handler f8850a;

    /* renamed from: b */
    private InterfaceC2469t f8851b;

    public C2466q(Handler handler, InterfaceC2469t interfaceC2469t) {
        this.f8850a = handler;
        m10674a(interfaceC2469t);
    }

    /* renamed from: a */
    public void m10674a(InterfaceC2469t interfaceC2469t) {
        this.f8851b = interfaceC2469t;
    }

    /* renamed from: a */
    public void m10672a(int i, Object obj) {
        this.f8850a.post(new RunnableC2467r(this, i, obj));
    }

    /* renamed from: a */
    public void m10673a(int i, Object obj, Object obj2) {
        this.f8850a.post(new RunnableC2470u(this, i, obj, obj2));
    }

    /* renamed from: b */
    protected void m10676b(int i, Object obj, Object obj2) {
        if (this.f8851b != null) {
            this.f8851b.mo9131a(i, obj, obj2);
        }
    }

    /* renamed from: b */
    protected void m10675b(int i, Object obj) {
        if (this.f8851b != null) {
            this.f8851b.mo9130a(i, obj);
        }
    }

    /* renamed from: a */
    public static boolean m10670a(int i) {
        if (!C2717y.m11398b()) {
            return false;
        }
        switch (i) {
            case 2:
            case 11:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 7002:
            case 7003:
                break;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m10671b(int i) {
        switch (i) {
            case 21:
            case 23:
            case 24:
            case 26:
                return true;
            case 22:
            case 25:
            default:
                return false;
        }
    }
}
