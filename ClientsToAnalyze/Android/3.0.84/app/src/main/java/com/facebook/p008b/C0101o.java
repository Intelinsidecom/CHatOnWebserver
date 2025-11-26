package com.facebook.p008b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.C0107ba;
import com.facebook.InterfaceC0120bn;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.o */
/* loaded from: classes.dex */
public class C0101o {

    /* renamed from: a */
    private C0107ba f189a;

    /* renamed from: b */
    private final InterfaceC0120bn f190b;

    /* renamed from: c */
    private final BroadcastReceiver f191c;

    /* renamed from: d */
    private final LocalBroadcastManager f192d;

    /* renamed from: e */
    private boolean f193e;

    public C0101o(Context context, InterfaceC0120bn interfaceC0120bn) {
        this(context, interfaceC0120bn, null);
    }

    C0101o(Context context, InterfaceC0120bn interfaceC0120bn, C0107ba c0107ba) {
        this(context, interfaceC0120bn, c0107ba, true);
    }

    public C0101o(Context context, InterfaceC0120bn interfaceC0120bn, C0107ba c0107ba, boolean z) {
        this.f193e = false;
        this.f190b = new C0104r(this, interfaceC0120bn);
        this.f189a = c0107ba;
        this.f191c = new C0103q(this);
        this.f192d = LocalBroadcastManager.getInstance(context);
        if (z) {
            m261c();
        }
    }

    /* renamed from: a */
    public C0107ba m258a() {
        return this.f189a == null ? C0107ba.m305j() : this.f189a;
    }

    /* renamed from: b */
    public C0107ba m260b() {
        C0107ba c0107baM258a = m258a();
        if (c0107baM258a == null || !c0107baM258a.m319b()) {
            return null;
        }
        return c0107baM258a;
    }

    /* renamed from: a */
    public void m259a(C0107ba c0107ba) {
        if (c0107ba == null) {
            if (this.f189a != null) {
                this.f189a.m318b(this.f190b);
                this.f189a = null;
                m257e();
                if (m258a() != null) {
                    m258a().m314a(this.f190b);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f189a == null) {
            C0107ba c0107baM305j = C0107ba.m305j();
            if (c0107baM305j != null) {
                c0107baM305j.m318b(this.f190b);
            }
            this.f192d.unregisterReceiver(this.f191c);
        } else {
            this.f189a.m318b(this.f190b);
        }
        this.f189a = c0107ba;
        this.f189a.m314a(this.f190b);
    }

    /* renamed from: c */
    public void m261c() {
        if (!this.f193e) {
            if (this.f189a == null) {
                m257e();
            }
            if (m258a() != null) {
                m258a().m314a(this.f190b);
            }
            this.f193e = true;
        }
    }

    /* renamed from: d */
    public boolean m262d() {
        return this.f193e;
    }

    /* renamed from: e */
    private void m257e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.f192d.registerReceiver(this.f191c, intentFilter);
    }
}
