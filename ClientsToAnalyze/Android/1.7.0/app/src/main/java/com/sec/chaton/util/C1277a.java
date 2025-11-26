package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p013a.C0225x;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.a */
/* loaded from: classes.dex */
public class C1277a {

    /* renamed from: a */
    private EnumC1289al f4458a = EnumC1289al.PRIMARY;

    /* renamed from: b */
    private C1295ar f4459b = new C1295ar(this, C1296as.m4524d(), C1296as.m4529f().intValue());

    /* renamed from: a */
    public void m4486a() {
        switch (this.f4458a) {
            case PRIMARY:
                this.f4459b.m4515a(C1296as.m4524d());
                this.f4459b.m4514a(C1296as.m4529f().intValue());
                break;
            case SECONDARY:
                this.f4459b.m4515a(C1296as.m4526e());
                this.f4459b.m4514a(C1296as.m4530g().intValue());
                break;
        }
        C1341p.m4658b("updateCurrentServer : " + this.f4459b.toString(), getClass().getSimpleName());
    }

    /* renamed from: b */
    public C1295ar m4488b() {
        return this.f4459b;
    }

    /* renamed from: a */
    public void m4487a(String str, int i) {
        C1341p.m4658b("request to change the server( old info ) : " + this.f4459b.toString(), getClass().getSimpleName());
        if (str.equals(this.f4459b.m4513a()) && i == this.f4459b.m4516b()) {
            m4485c();
        }
    }

    /* renamed from: c */
    private void m4485c() {
        switch (this.f4458a) {
            case PRIMARY:
                this.f4459b.m4515a(C1296as.m4526e());
                this.f4459b.m4514a(C1296as.m4530g().intValue());
                this.f4458a = EnumC1289al.SECONDARY;
                C1341p.m4658b("change server PRIMARY --> SECONDARY :" + this.f4459b.toString(), getClass().getSimpleName());
                break;
            case SECONDARY:
                this.f4459b.m4515a(C1296as.m4524d());
                this.f4459b.m4514a(C1296as.m4529f().intValue());
                this.f4458a = EnumC1289al.PRIMARY;
                C1341p.m4658b("change server SECONDARY --> PRIMARY:" + this.f4459b.toString(), getClass().getSimpleName());
                new C0225x(new Handler(Looper.getMainLooper())).m869a();
                C1341p.m4658b("request GLD", getClass().getSimpleName());
                break;
        }
    }
}
