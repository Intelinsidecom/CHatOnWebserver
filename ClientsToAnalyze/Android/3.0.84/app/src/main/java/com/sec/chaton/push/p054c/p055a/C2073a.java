package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
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
import com.sec.p013a.p014a.p015a.C0238c;
import com.sec.p013a.p014a.p015a.C0241f;
import com.sec.p013a.p014a.p015a.C0242g;

/* compiled from: DeregistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.a */
/* loaded from: classes.dex */
public class C2073a extends AbstractC2072a implements InterfaceC2083d {

    /* renamed from: a */
    private static final String f7944a = C2073a.class.getSimpleName();

    /* renamed from: b */
    private int f7945b;

    /* renamed from: c */
    private String f7946c;

    /* renamed from: d */
    private C2060d f7947d;

    /* renamed from: e */
    private InterfaceC2081b f7948e;

    public C2073a(Context context, String str) {
        super(context, 2L);
        this.f7946c = str;
        this.f7947d = PushClientApplication.m8156h().m8159j();
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: f_ */
    public Class<? extends GeneratedMessageLite> mo8197f_() {
        return C0238c.class;
    }

    /* renamed from: a */
    public void m8196a(InterfaceC2081b interfaceC2081b) {
        this.f7948e = interfaceC2081b;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7944a, "DeregistrationMessageTask.onRequest().");
        }
        String strM8306e = C2099k.m8306e((String) null);
        if (strM8306e == null || !strM8306e.equals(this.f7946c)) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f7944a, String.format("The application(id:%s) had been deregistered. callback success to application without networking.", this.f7946c));
            }
            if (this.f7948e == null) {
                return null;
            }
            this.f7948e.mo8215a();
            return null;
        }
        if (!C2074b.m8200d()) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7944a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2074b(m8192a()));
                C2088i.m8241a().m8248a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C2115g.f8051d) {
                    return null;
                }
                C2115g.m8360a(f7944a, e.getMessage(), e);
                return null;
            }
        }
        this.f7945b = C2112d.m8341a();
        C0242g c0242gNewBuilder = C0241f.newBuilder();
        c0242gNewBuilder.m865a(this.f7945b);
        c0242gNewBuilder.m868a(C2099k.m8292b((String) null));
        c0242gNewBuilder.m870b(C2099k.m8309f((String) null));
        c0242gNewBuilder.m872c("");
        return new C2087h().m8239a(this.f7947d).m8238a(c0242gNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: a */
    public void mo8195a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7944a, String.format("DeregistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7944a, "Response message is null.");
                    return;
                }
                return;
            }
            C0238c c0238c = (C0238c) generatedMessageLite;
            int iM813f = c0238c.m813f();
            if (this.f7945b != c0238c.m811d()) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f7944a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f7945b), Integer.valueOf(c0238c.m811d())));
                    return;
                }
                return;
            }
            if (iM813f == 1000) {
                SharedPreferences.Editor editorM8284a = C2099k.m8284a();
                C2099k.m8319j(editorM8284a);
                C2099k.m8320k(editorM8284a);
                editorM8284a.commit();
                try {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7944a, "Close connection.");
                    }
                    this.f7947d.mo8184b();
                } catch (C2044a e) {
                }
                HeartBeat.m8266d();
                m8192a().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f7948e != null) {
                    this.f7948e.mo8215a();
                    return;
                }
                return;
            }
            if (C2115g.f8051d) {
                C2115g.m8364d(f7944a, String.format("Deregistration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM813f)));
            }
            if (iM813f == 4002 || iM813f == 4009) {
                if (C2115g.f8051d) {
                    if (iM813f == 4002) {
                        if (C2115g.f8051d) {
                            C2115g.m8364d(f7944a, "Server error: empty device token.");
                        }
                    } else if (iM813f == 4009 && C2115g.f8051d) {
                        C2115g.m8364d(f7944a, "Server error: wrong device token.");
                    }
                }
                try {
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7944a, "Close connection.");
                    }
                    this.f7947d.mo8184b();
                } catch (C2044a e2) {
                }
                C2099k.m8293b();
                C2045b.m8162a().m8170e();
                if (this.f7948e != null) {
                    this.f7948e.mo8216a(iM813f);
                    return;
                }
                return;
            }
            if (iM813f == 4004) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7944a, "Server error: empty application id.");
                    C2115g.m8364d(f7944a, "Do not anything.");
                }
                if (this.f7948e != null) {
                    this.f7948e.mo8216a(iM813f);
                    return;
                }
                return;
            }
            if (iM813f == 4001) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7944a, "Server error: invalid state.");
                    C2115g.m8364d(f7944a, "Close connection.");
                }
                try {
                    this.f7947d.mo8184b();
                } catch (C2044a e3) {
                }
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7944a, "Execute initialization.");
                }
                C2045b.m8162a().m8170e();
                if (this.f7948e != null) {
                    this.f7948e.mo8216a(iM813f);
                    return;
                }
                return;
            }
            if (iM813f == 4008) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7944a, "Server error: invalid state.");
                    C2115g.m8364d(f7944a, "Close connection.");
                }
                if (this.f7948e != null) {
                    this.f7948e.mo8216a(iM813f);
                    return;
                }
                return;
            }
            if (this.f7948e != null) {
                this.f7948e.mo8216a(iM813f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7944a, "Internal error code is timeout.");
            }
            try {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7944a, "Disconnect connection.");
                }
                this.f7947d.mo8184b();
            } catch (C2044a e4) {
            }
            C2045b.m8162a().m8170e();
        }
        if (this.f7948e != null) {
            this.f7948e.mo8216a(i);
        }
    }
}
