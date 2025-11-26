package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.C2087h;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.p054c.InterfaceC2083d;
import com.sec.chaton.push.util.C2112d;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;
import com.sec.p013a.p014a.p015a.C0221aa;
import com.sec.p013a.p014a.p015a.C0222ab;
import com.sec.p013a.p014a.p015a.C0259x;

/* compiled from: PingMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.e */
/* loaded from: classes.dex */
public class C2077e extends AbstractC2072a implements InterfaceC2083d {

    /* renamed from: a */
    private static final String f7960a = C2077e.class.getSimpleName();

    /* renamed from: b */
    private int f7961b;

    /* renamed from: c */
    private C2060d f7962c;

    /* renamed from: d */
    private InterfaceC2081b f7963d;

    public C2077e(Context context) {
        super(context, 2L);
        this.f7962c = PushClientApplication.m8156h().m8159j();
    }

    /* renamed from: a */
    public void m8207a(InterfaceC2081b interfaceC2081b) {
        this.f7963d = interfaceC2081b;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: f_ */
    public Class<? extends GeneratedMessageLite> mo8197f_() {
        return C0259x.class;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7960a, "PingMessageTask.onRequest().");
        }
        if (!C2074b.m8200d()) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7960a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2074b(m8192a()));
                C2088i.m8241a().m8248a(this);
            } catch (InterruptedException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(f7960a, e.getMessage(), e);
                }
            }
            return null;
        }
        this.f7961b = C2112d.m8341a();
        C0222ab c0222abNewBuilder = C0221aa.newBuilder();
        c0222abNewBuilder.m602a(this.f7961b);
        c0222abNewBuilder.m603a(System.currentTimeMillis());
        c0222abNewBuilder.m607b(C2099k.m8296c(8));
        return new C2087h().m8239a(this.f7962c).m8238a(c0222abNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: a */
    public void mo8195a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7960a, String.format("PingMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7960a, "Response message is null.");
                    return;
                }
                return;
            }
            C0259x c0259x = (C0259x) generatedMessageLite;
            if (this.f7961b != c0259x.m1068d()) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f7960a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f7961b), Integer.valueOf(c0259x.m1068d())));
                    return;
                }
                return;
            } else {
                if (this.f7963d != null) {
                    this.f7963d.mo8215a();
                    return;
                }
                return;
            }
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f7960a, "Close connection.");
        }
        try {
            this.f7962c.mo8184b();
        } catch (C2044a e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7960a, e.getMessage(), e);
            }
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f7960a, "Execeute initialize.");
        }
        try {
            C2088i.m8241a().m8248a(new C2074b(CommonApplication.m11493l()));
        } catch (InterruptedException e2) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7960a, e2.getMessage(), e2);
            }
        }
        if (this.f7963d != null) {
            this.f7963d.mo8216a(i);
        }
    }
}
