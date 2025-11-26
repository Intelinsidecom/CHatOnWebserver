package com.facebook.p032b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.C0096i;
import com.facebook.C0478ba;
import com.facebook.InterfaceC0491bn;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.o */
/* loaded from: classes.dex */
public class C0472o {

    /* renamed from: a */
    private C0478ba f1158a;

    /* renamed from: b */
    private final InterfaceC0491bn f1159b;

    /* renamed from: c */
    private final BroadcastReceiver f1160c;

    /* renamed from: d */
    private final C0096i f1161d;

    /* renamed from: e */
    private boolean f1162e;

    public C0472o(Context context, InterfaceC0491bn interfaceC0491bn) {
        this(context, interfaceC0491bn, null);
    }

    C0472o(Context context, InterfaceC0491bn interfaceC0491bn, C0478ba c0478ba) {
        this(context, interfaceC0491bn, c0478ba, true);
    }

    public C0472o(Context context, InterfaceC0491bn interfaceC0491bn, C0478ba c0478ba, boolean z) {
        this.f1162e = false;
        this.f1159b = new C0475r(this, interfaceC0491bn);
        this.f1158a = c0478ba;
        this.f1160c = new C0474q(this);
        this.f1161d = C0096i.m358a(context);
        if (z) {
            m1705c();
        }
    }

    /* renamed from: a */
    public C0478ba m1702a() {
        return this.f1158a == null ? C0478ba.m1749j() : this.f1158a;
    }

    /* renamed from: b */
    public C0478ba m1704b() {
        C0478ba c0478baM1702a = m1702a();
        if (c0478baM1702a == null || !c0478baM1702a.m1762b()) {
            return null;
        }
        return c0478baM1702a;
    }

    /* renamed from: a */
    public void m1703a(C0478ba c0478ba) {
        if (c0478ba == null) {
            if (this.f1158a != null) {
                this.f1158a.m1761b(this.f1159b);
                this.f1158a = null;
                m1701e();
                if (m1702a() != null) {
                    m1702a().m1758a(this.f1159b);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f1158a == null) {
            C0478ba c0478baM1749j = C0478ba.m1749j();
            if (c0478baM1749j != null) {
                c0478baM1749j.m1761b(this.f1159b);
            }
            this.f1161d.m361a(this.f1160c);
        } else {
            this.f1158a.m1761b(this.f1159b);
        }
        this.f1158a = c0478ba;
        this.f1158a.m1758a(this.f1159b);
    }

    /* renamed from: c */
    public void m1705c() {
        if (!this.f1162e) {
            if (this.f1158a == null) {
                m1701e();
            }
            if (m1702a() != null) {
                m1702a().m1758a(this.f1159b);
            }
            this.f1162e = true;
        }
    }

    /* renamed from: d */
    public boolean m1706d() {
        return this.f1162e;
    }

    /* renamed from: e */
    private void m1701e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.f1161d.m362a(this.f1160c, intentFilter);
    }
}
