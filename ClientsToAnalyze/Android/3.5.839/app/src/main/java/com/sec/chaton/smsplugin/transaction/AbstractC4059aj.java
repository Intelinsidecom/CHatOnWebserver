package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3881d;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.google.android.p134a.C5111c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: Transaction.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.aj */
/* loaded from: classes.dex */
public abstract class AbstractC4059aj extends AbstractC4083s {

    /* renamed from: f */
    private static final String f14637f = AbstractC4059aj.class.getSimpleName();

    /* renamed from: a */
    private final int f14638a;

    /* renamed from: b */
    protected Context f14639b;

    /* renamed from: c */
    protected String f14640c;

    /* renamed from: d */
    protected C4065ap f14641d = new C4065ap();

    /* renamed from: e */
    protected C4064ao f14642e;

    /* renamed from: a */
    public abstract void mo15597a();

    /* renamed from: b */
    public abstract int mo15598b();

    public AbstractC4059aj(Context context, int i, C4064ao c4064ao) {
        this.f14639b = context;
        this.f14638a = i;
        this.f14642e = c4064ao;
    }

    /* renamed from: e */
    public C4065ap m15619e() {
        return this.f14641d;
    }

    /* renamed from: a */
    public boolean m15613a(AbstractC4059aj abstractC4059aj) {
        if (getClass().equals(RunnableC4082r.class) && abstractC4059aj.getClass().equals(RunnableC4089y.class)) {
            boolean zM14978a = C3881d.m14970b().m14978a();
            boolean z = GlobalApplication.m10279a().m10295j().getDataState() == 3;
            C3896s.m15044b("[Transaction] autoDownload : " + zM14978a, f14637f);
            C3896s.m15044b("[Transaction] dataSuspended : " + z, f14637f);
            C3896s.m15044b("[Transaction] DataState : " + GlobalApplication.m10279a().m10295j().getDataState(), f14637f);
            if (!zM14978a || z) {
                return false;
            }
            return ((RunnableC4082r) this).m15694c().equals(((RunnableC4089y) abstractC4059aj).m15706c());
        }
        return getClass().equals(abstractC4059aj.getClass()) && this.f14640c.equals(abstractC4059aj.f14640c);
    }

    /* renamed from: f */
    public int m15620f() {
        return this.f14638a;
    }

    /* renamed from: g */
    public C4064ao m15621g() {
        return this.f14642e;
    }

    /* renamed from: a */
    public void m15612a(C4064ao c4064ao) {
        this.f14642e = c4064ao;
    }

    /* renamed from: a */
    protected byte[] m15617a(byte[] bArr) {
        return m15615a(-1L, bArr, this.f14642e.m15637a());
    }

    /* renamed from: a */
    protected byte[] m15618a(byte[] bArr, String str) {
        return m15615a(-1L, bArr, str);
    }

    /* renamed from: a */
    protected byte[] m15614a(long j, byte[] bArr) {
        return m15615a(j, bArr, this.f14642e.m15637a());
    }

    /* renamed from: a */
    protected byte[] m15615a(long j, byte[] bArr, String str) throws C5111c, IOException {
        if (bArr == null) {
            throw new C5111c();
        }
        m15610a(str, this.f14642e);
        return C4074j.m15686a(this.f14639b, j, str, bArr, 1, this.f14642e.m15640d(), this.f14642e.m15638b(), this.f14642e.m15639c());
    }

    /* renamed from: a */
    protected byte[] m15616a(String str) throws IOException {
        m15610a(str, this.f14642e);
        return C4074j.m15686a(this.f14639b, -1L, str, null, 2, this.f14642e.m15640d(), this.f14642e.m15638b(), this.f14642e.m15639c());
    }

    /* renamed from: a */
    private void m15610a(String str, C4064ao c4064ao) throws IOException {
        boolean z;
        boolean z2;
        boolean z3 = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f14639b.getSystemService("connectivity");
        if (C3847e.m14657aH() && C3847e.m14626J()) {
            if (c4064ao.m15640d()) {
                try {
                    InetAddress byName = InetAddress.getByName(c4064ao.m15638b());
                    if (!connectivityManager.requestRouteToHostAddress(2, byName)) {
                        throw new IOException("Cannot establish route to proxy " + byName.getAddress());
                    }
                    return;
                } catch (UnknownHostException e) {
                    throw new IOException("Cannot establish route for " + str + ": Unknown host");
                }
            }
            try {
                InetAddress byName2 = InetAddress.getByName(Uri.parse(str).getHost());
                if (!C3847e.m14621E() || connectivityManager == null) {
                    z2 = true;
                } else {
                    z2 = connectivityManager.getNetworkInfo(2).isAvailable() && connectivityManager.getMobileDataEnabled();
                }
                if (!C3847e.m14622F()) {
                    z3 = z2;
                } else if (C3847e.m14623G()) {
                    z3 = false;
                }
                if (!connectivityManager.requestRouteToHostAddress(2, byName2) && z3) {
                    throw new IOException("Cannot establish route to " + byName2.getAddress() + " for " + str);
                }
                return;
            } catch (UnknownHostException e2) {
                throw new IOException("Cannot establish route for " + str + ": Unknown host");
            }
        }
        if (c4064ao.m15640d()) {
            int iM15611b = m15611b(c4064ao.m15638b());
            if (iM15611b == -1) {
                throw new IOException("Cannot establish route for " + str + ": Unknown host");
            }
            if (!connectivityManager.requestRouteToHost(2, iM15611b)) {
                throw new IOException("Cannot establish route to proxy " + iM15611b);
            }
            return;
        }
        int iM15611b2 = m15611b(Uri.parse(str).getHost());
        if (iM15611b2 == -1) {
            throw new IOException("Cannot establish route for " + str + ": Unknown host");
        }
        if (C3847e.m14657aH()) {
            if (!C3847e.m14621E() || connectivityManager == null) {
                z = true;
            } else {
                z = connectivityManager.getNetworkInfo(2).isAvailable() && connectivityManager.getMobileDataEnabled();
            }
            if (!C3847e.m14622F()) {
                z3 = z;
            } else if (C3847e.m14623G()) {
                z3 = false;
            }
        }
        if (!connectivityManager.requestRouteToHost(2, iM15611b2) && z3) {
            throw new IOException("Cannot establish route to " + iM15611b2 + " for " + str);
        }
    }

    /* renamed from: b */
    public static int m15611b(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (UnknownHostException e) {
            return -1;
        }
    }

    public String toString() {
        return getClass().getName() + ": serviceId=" + this.f14638a;
    }
}
