package com.sec.chaton.p037j;

import android.os.Handler;
import com.sec.chaton.msgsend.C1757q;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.j.q */
/* loaded from: classes.dex */
public class C1589q {

    /* renamed from: a */
    final Handler f5902a;

    /* renamed from: b */
    private InterfaceC1592t f5903b;

    public C1589q(Handler handler, InterfaceC1592t interfaceC1592t) {
        this.f5902a = handler;
        m6730a(interfaceC1592t);
    }

    /* renamed from: a */
    public void m6730a(InterfaceC1592t interfaceC1592t) {
        this.f5903b = interfaceC1592t;
    }

    /* renamed from: a */
    public void m6728a(int i, Object obj) {
        this.f5902a.post(new RunnableC1590r(this, i, obj));
    }

    /* renamed from: a */
    public void m6729a(int i, Object obj, Object obj2) {
        this.f5902a.post(new RunnableC1593u(this, i, obj, obj2));
    }

    /* renamed from: b */
    protected void m6732b(int i, Object obj, Object obj2) {
        if (this.f5903b != null) {
            this.f5903b.mo5553a(i, obj, obj2);
        }
    }

    /* renamed from: b */
    protected void m6731b(int i, Object obj) {
        if (this.f5903b != null) {
            this.f5903b.mo5552a(i, obj);
        }
    }

    /* renamed from: a */
    public static boolean m6726a(int i) {
        if (!C1757q.m7251b()) {
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
                break;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m6727b(int i) {
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
