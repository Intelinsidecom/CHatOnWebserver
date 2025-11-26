package com.sec.chaton.privateplugin.p088a;

import android.os.Handler;
import com.google.p034a.C0676j;
import com.sec.chaton.plugin.p083b.AbstractC2929f;
import com.sec.chaton.plugin.p083b.C2925b;
import com.sec.chaton.plugin.p083b.C2927d;
import com.sec.chaton.plugin.p083b.C2930g;
import com.sec.chaton.plugin.p083b.C2931h;
import com.sec.chaton.plugin.p083b.EnumC2926c;
import com.sec.chaton.plugin.p086e.C2944c;
import com.sec.chaton.plugin.p086e.InterfaceC2942a;
import com.sec.chaton.plugin.p087f.C2946a;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.SetSpamResp;
import java.io.IOException;
import java.net.URL;

/* compiled from: SetSpamTask.java */
/* renamed from: com.sec.chaton.privateplugin.a.b */
/* loaded from: classes.dex */
public class C3033b extends AbstractC3032a {

    /* renamed from: a */
    private static final String f11222a = C3033b.class.getSimpleName();

    /* renamed from: b */
    private AbstractC2929f f11223b;

    /* renamed from: c */
    private InterfaceC2942a f11224c;

    /* renamed from: d */
    private URL f11225d;

    /* renamed from: e */
    private C2931h f11226e;

    public C3033b(String str, int i, SetSpamReq setSpamReq, Handler handler) {
        super(i);
        this.f11224c = new C2944c(this, handler);
        C2927d c2927dM12160a = new C2927d(str).m12160a("/spamfilter");
        String strM2164a = new C0676j().m2164a(setSpamReq);
        this.f11225d = c2927dM12160a.m12161a();
        C2946a.m12189b(this.f11225d.toString(), f11222a);
        this.f11223b = new C2930g();
        this.f11226e = new C2931h(strM2164a);
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        C2925b.m12159a(this.f11225d, EnumC2926c.POST, this.f11226e, this.f11223b, 30000, 30000, "application/json", null, this.f11224c);
    }

    @Override // com.sec.chaton.plugin.p086e.AbstractRunnableC2943b
    /* renamed from: a */
    protected Object mo12183a(String str) {
        try {
            return (SetSpamResp) new C0676j().m2161a(str, SetSpamResp.class);
        } catch (Exception e) {
            C2946a.m12187a(e, f11222a);
            return null;
        }
    }
}
