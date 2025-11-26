package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p050a.C2054k;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.C2087h;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.p054c.InterfaceC2083d;
import com.sec.chaton.push.util.C2112d;
import com.sec.chaton.push.util.C2113e;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;
import com.sec.p013a.p014a.p015a.C0244i;
import com.sec.p013a.p014a.p015a.C0247l;
import com.sec.p013a.p014a.p015a.C0248m;

/* compiled from: InitMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.b */
/* loaded from: classes.dex */
public class C2074b extends AbstractC2072a implements InterfaceC2083d {

    /* renamed from: a */
    private static final String f7949a = C2074b.class.getSimpleName();

    /* renamed from: b */
    private static boolean f7950b;

    /* renamed from: c */
    private int f7951c;

    /* renamed from: d */
    private C2060d f7952d;

    /* renamed from: e */
    private InterfaceC2081b f7953e;

    public C2074b(Context context) {
        super(context, 1L);
        this.f7952d = PushClientApplication.m8156h().m8159j();
        this.f7953e = null;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: f_ */
    public Class<? extends GeneratedMessageLite> mo8197f_() {
        return C0244i.class;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7949a, "InitMessageTask.onRequest().");
        }
        C2045b.m8162a().m8171f();
        if (C2113e.m8355a() == EnumC2114f.Mobile) {
            String strM8356b = C2113e.m8356b();
            String strM8315h = C2099k.m8315h((String) null);
            if (strM8356b == null || !strM8356b.equals(strM8315h)) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "The network operator is changed. New(" + strM8356b + "), Old(" + strM8315h + ").");
                    C2115g.m8359a(f7949a, "Execute re-provisioning.");
                }
                C2099k.m8293b();
                C2099k.m8298c();
            }
        }
        if (!C2078f.m8209a(m8192a())) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7949a, "Provisioning isn't completed. Execute provisioning before initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2078f(m8192a()));
                return null;
            } catch (InterruptedException e) {
                if (!C2115g.f8051d) {
                    return null;
                }
                C2115g.m8360a(f7949a, e.getMessage(), e);
                return null;
            }
        }
        if (m8200d()) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f7949a, "Initialization already has been completed. Don't execute re-initialize.");
            }
            if (this.f7953e == null) {
                return null;
            }
            this.f7953e.mo8216a(-102);
            return null;
        }
        try {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7949a, "Disconnect connection before initialize.");
            }
            this.f7952d.mo8184b();
        } catch (Exception e2) {
        }
        String strM8210b = C2078f.m8210b(m8192a());
        int iM8211c = C2078f.m8211c(m8192a());
        if (C2115g.f8049b) {
            C2115g.m8362b(f7949a, String.format("Connect to push server(%s:%s).", strM8210b, Integer.valueOf(iM8211c)));
        }
        try {
            this.f7952d.mo8180a(strM8210b, iM8211c, true);
        } catch (C2054k e3) {
            if (C2115g.f8051d) {
                C2115g.m8364d(f7949a, "There isn't available network in device.");
            }
            m8198a(-104);
            if (this.f7953e == null) {
                return null;
            }
            this.f7953e.mo8216a(-2);
            return null;
        } catch (C2044a e4) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7949a, "Can't connect to push server.", e4);
            }
            if (C2115g.f8049b) {
                C2115g.m8362b(f7949a, "Switch push server address.");
            }
            C2078f.m8212d();
            String strM8210b2 = C2078f.m8210b(m8192a());
            int iM8211c2 = C2078f.m8211c(m8192a());
            if (C2115g.f8049b) {
                C2115g.m8362b(f7949a, String.format("Connect to push server(%s:%s).", strM8210b2, Integer.valueOf(iM8211c2)));
            }
            try {
                this.f7952d.mo8180a(strM8210b2, iM8211c2, true);
            } catch (C2054k e5) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7949a, "There isn't available network in device.");
                }
                C2078f.m8212d();
                m8198a(-104);
                if (this.f7953e == null) {
                    return null;
                }
                this.f7953e.mo8216a(-2);
                return null;
            } catch (C2044a e6) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(f7949a, "Can't connect to push server.", e6);
                }
                C2078f.m8212d();
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "Execute re-provisioning.");
                }
                C2099k.m8293b();
                m8198a(-104);
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "Couldn't connect primary and secondary push server. execute re-provisioning.");
                }
                C2045b.m8162a().m8170e();
                if (this.f7953e == null) {
                    return null;
                }
                this.f7953e.mo8216a(-104);
                return null;
            }
        }
        this.f7951c = C2112d.m8341a();
        C0248m c0248mNewBuilder = C0247l.newBuilder();
        c0248mNewBuilder.m929a(this.f7951c);
        c0248mNewBuilder.m932a(C2099k.m8292b((String) null));
        return new C2087h().m8239a(this.f7952d).m8238a(c0248mNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: a */
    public void mo8195a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7949a, String.format("InitMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7949a, "Response message is null.");
                    return;
                }
                return;
            }
            C0244i c0244i = (C0244i) generatedMessageLite;
            int iM888f = c0244i.m888f();
            if (this.f7951c != c0244i.m886d()) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f7949a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f7951c), Integer.valueOf(c0244i.m886d())));
                    return;
                }
                return;
            }
            if (iM888f == 1000) {
                m8201e();
                C2045b.m8162a().m8172g();
                if (PushClientApplication.m8156h().m8158i()) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7949a, "Start HeartBeat.");
                    }
                    HeartBeat.m8265c();
                } else if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "HeartBeat will not be started hence push service hadn't been started.");
                }
                if (this.f7953e != null) {
                    this.f7953e.mo8215a();
                    return;
                }
                return;
            }
            if (C2115g.f8051d) {
                C2115g.m8364d(f7949a, String.format("Init reply result code is error. ErrorCode: %d.", Integer.valueOf(iM888f)));
            }
            m8202f();
            m8198a(-104);
            if (iM888f == 4002 || iM888f == 4006) {
                try {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7949a, "Disconnect connection.");
                    }
                    this.f7952d.mo8184b();
                } catch (C2044a e) {
                }
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "Execute reprovisioning.");
                }
                C2099k.m8293b();
                C2045b.m8162a().m8170e();
                if (this.f7953e != null) {
                    this.f7953e.mo8216a(-104);
                    return;
                }
                return;
            }
            if (iM888f == 2002) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7949a, "Server error: internal server error.");
                }
                if (C2078f.m8213e() == EnumC2079g.Primary) {
                    try {
                        if (C2115g.f8048a) {
                            C2115g.m8359a(f7949a, "Disconnect connection.");
                        }
                        this.f7952d.mo8184b();
                    } catch (C2044a e2) {
                    }
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7949a, "Retry initialize using secondary push server.");
                    }
                    C2078f.m8212d();
                    C2045b.m8162a().m8170e();
                    if (this.f7953e != null) {
                        this.f7953e.mo8216a(-104);
                        return;
                    }
                    return;
                }
                if (C2078f.m8213e() == EnumC2079g.Secondary) {
                    try {
                        if (C2115g.f8048a) {
                            C2115g.m8359a(f7949a, "Disconnect connection.");
                        }
                        this.f7952d.mo8184b();
                    } catch (C2044a e3) {
                    }
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7949a, "Execute re-provisioning.");
                    }
                    C2099k.m8293b();
                    C2045b.m8162a().m8170e();
                    if (this.f7953e != null) {
                        this.f7953e.mo8216a(-104);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iM888f == 2003) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7949a, "Server error: interrupted.");
                }
                try {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7949a, "Disconnect connection.");
                    }
                    this.f7952d.mo8184b();
                } catch (C2044a e4) {
                }
                C2045b.m8162a().m8170e();
                if (this.f7953e != null) {
                    this.f7953e.mo8216a(-104);
                    return;
                }
                return;
            }
            return;
        }
        m8202f();
        m8198a(-104);
        if (i == -1) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7949a, "Internal error code is timeout.");
            }
            try {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7949a, "Disconnect connection.");
                }
                this.f7952d.mo8184b();
            } catch (C2044a e5) {
            }
            C2045b.m8162a().m8170e();
        }
        if (this.f7953e != null) {
            this.f7953e.mo8216a(-104);
        }
    }

    /* renamed from: a */
    private void m8198a(int i) {
        C2045b.m8162a().m8165a(i);
    }

    /* renamed from: a */
    public static synchronized boolean m8199a(boolean z) {
        if (f7950b && !PushClientApplication.m8156h().m8159j().m8183a(z)) {
            f7950b = false;
        }
        return f7950b;
    }

    /* renamed from: d */
    public static synchronized boolean m8200d() {
        return m8199a(true);
    }

    /* renamed from: e */
    public static synchronized void m8201e() {
        f7950b = true;
    }

    /* renamed from: f */
    public static synchronized void m8202f() {
        f7950b = false;
    }
}
