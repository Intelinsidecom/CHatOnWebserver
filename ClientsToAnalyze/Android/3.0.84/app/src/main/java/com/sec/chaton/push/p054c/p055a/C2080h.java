package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.C2087h;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.p054c.InterfaceC2083d;
import com.sec.chaton.push.util.C2112d;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;
import com.sec.p013a.p014a.p015a.C0230aj;
import com.sec.p013a.p014a.p015a.C0233am;
import com.sec.p013a.p014a.p015a.C0234an;

/* compiled from: RegistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.h */
/* loaded from: classes.dex */
public class C2080h extends AbstractC2072a implements InterfaceC2083d {

    /* renamed from: a */
    private static final String f7972a = AbstractC2072a.class.getSimpleName();

    /* renamed from: b */
    private int f7973b;

    /* renamed from: c */
    private String f7974c;

    /* renamed from: d */
    private C2060d f7975d;

    /* renamed from: e */
    private InterfaceC2081b f7976e;

    public C2080h(Context context, String str) {
        super(context, 2L);
        this.f7974c = str;
        this.f7975d = ((PushClientApplication) CommonApplication.m11493l()).m8159j();
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: f_ */
    public Class<? extends GeneratedMessageLite> mo8197f_() {
        return C0230aj.class;
    }

    /* renamed from: a */
    public void m8214a(InterfaceC2081b interfaceC2081b) {
        this.f7976e = interfaceC2081b;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7972a, "RegistrationMessageTask.onRequest().");
        }
        if (!C2074b.m8200d()) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7972a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2074b(m8192a()));
                C2088i.m8241a().m8248a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C2115g.f8051d) {
                    return null;
                }
                C2115g.m8360a(f7972a, e.getMessage(), e);
                return null;
            }
        }
        this.f7973b = C2112d.m8341a();
        C0234an c0234anNewBuilder = C0233am.newBuilder();
        c0234anNewBuilder.m784a(this.f7973b);
        c0234anNewBuilder.m787a(C2099k.m8292b((String) null));
        c0234anNewBuilder.m789b(this.f7974c);
        c0234anNewBuilder.m791c("");
        return new C2087h().m8239a(this.f7975d).m8238a(c0234anNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: a */
    public void mo8195a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7972a, String.format("RegistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7972a, "Response message is null.");
                    return;
                }
                return;
            }
            C0230aj c0230aj = (C0230aj) generatedMessageLite;
            int iM729f = c0230aj.m729f();
            if (this.f7973b != c0230aj.m727d()) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f7972a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f7973b), Integer.valueOf(c0230aj.m727d())));
                    return;
                }
                return;
            }
            if (iM729f == 1000) {
                SharedPreferences.Editor editorM8284a = C2099k.m8284a();
                C2099k.m8295b(editorM8284a, this.f7974c);
                C2099k.m8300c(editorM8284a, c0230aj.m733j());
                editorM8284a.commit();
                m8192a().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f7976e != null) {
                    this.f7976e.mo8215a();
                    return;
                }
                return;
            }
            if (C2115g.f8051d) {
                C2115g.m8364d(f7972a, String.format("Registration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM729f)));
            }
            if (iM729f == 4002) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7972a, "Server error: empty device token.");
                    C2115g.m8364d(f7972a, "Close connection.");
                }
                try {
                    this.f7975d.mo8184b();
                } catch (C2044a e) {
                }
                C2099k.m8293b();
                C2045b.m8162a().m8170e();
                if (this.f7976e != null) {
                    this.f7976e.mo8216a(iM729f);
                    return;
                }
                return;
            }
            if (iM729f == 4003) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7972a, "Server error: empty application id.");
                    C2115g.m8364d(f7972a, "Do not anything.");
                }
                try {
                    this.f7975d.mo8184b();
                } catch (C2044a e2) {
                }
                C2045b.m8162a().m8170e();
                if (this.f7976e != null) {
                    this.f7976e.mo8216a(iM729f);
                    return;
                }
                return;
            }
            if (iM729f == 4001) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7972a, "Server error: empty device token.");
                    C2115g.m8364d(f7972a, "Close connection.");
                }
                try {
                    this.f7975d.mo8184b();
                } catch (C2044a e3) {
                }
                C2045b.m8162a().m8170e();
                if (this.f7976e != null) {
                    this.f7976e.mo8216a(iM729f);
                    return;
                }
                return;
            }
            if (iM729f == 4007) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7972a, "Server error: registration failed.");
                    C2115g.m8364d(f7972a, "Do not anything.");
                }
                if (this.f7976e != null) {
                    this.f7976e.mo8216a(iM729f);
                    return;
                }
                return;
            }
            if (this.f7976e != null) {
                this.f7976e.mo8216a(iM729f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7972a, "Internal error code is timeout.");
            }
            try {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7972a, "Disconnect connection.");
                }
                this.f7975d.mo8184b();
            } catch (C2044a e4) {
            }
            C2045b.m8162a().m8170e();
        }
        if (this.f7976e != null) {
            this.f7976e.mo8216a(i);
        }
    }
}
