package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p015d.C0634f;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.as */
/* loaded from: classes.dex */
public class C1736as {

    /* renamed from: a */
    private EnumC1764bt f6345a = EnumC1764bt.PRIMARY;

    /* renamed from: b */
    private C1738au f6346b = new C1738au(this, C1763bs.m5976d(), C1763bs.m5981f().intValue());

    /* renamed from: a */
    public void m5920a() {
        switch (this.f6345a) {
            case PRIMARY:
                this.f6346b.m5925a(C1763bs.m5976d());
                this.f6346b.m5924a(C1763bs.m5981f().intValue());
                break;
            case SECONDARY:
                this.f6346b.m5925a(C1763bs.m5978e());
                this.f6346b.m5924a(C1763bs.m5982g().intValue());
                break;
        }
        C1786r.m6061b("updateCurrentServer : " + this.f6346b.toString(), getClass().getSimpleName());
    }

    /* renamed from: b */
    public C1738au m5922b() {
        return this.f6346b;
    }

    /* renamed from: a */
    public void m5921a(String str, int i) {
        C1786r.m6061b("request to change the server( old info ) : " + this.f6346b.toString(), getClass().getSimpleName());
        if (str.equals(this.f6346b.m5923a()) && i == this.f6346b.m5926b()) {
            m5919c();
        }
    }

    /* renamed from: c */
    private void m5919c() {
        switch (this.f6345a) {
            case PRIMARY:
                this.f6346b.m5925a(C1763bs.m5978e());
                this.f6346b.m5924a(C1763bs.m5982g().intValue());
                this.f6345a = EnumC1764bt.SECONDARY;
                C1786r.m6061b("change server PRIMARY --> SECONDARY :" + this.f6346b.toString(), getClass().getSimpleName());
                break;
            case SECONDARY:
                this.f6346b.m5925a(C1763bs.m5976d());
                this.f6346b.m5924a(C1763bs.m5981f().intValue());
                this.f6345a = EnumC1764bt.PRIMARY;
                C1786r.m6061b("change server SECONDARY --> PRIMARY:" + this.f6346b.toString(), getClass().getSimpleName());
                new C0634f(new Handler(Looper.getMainLooper())).m2884a();
                C1786r.m6061b("request GLD", getClass().getSimpleName());
                break;
        }
    }
}
