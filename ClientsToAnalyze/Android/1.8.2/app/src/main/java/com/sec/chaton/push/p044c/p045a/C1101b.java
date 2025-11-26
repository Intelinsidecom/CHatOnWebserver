package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p040a.C1081k;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.C1114h;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.p044c.InterfaceC1110d;
import com.sec.chaton.push.util.C1136d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0080i;
import com.sec.p004a.p005a.p006a.C0083l;
import com.sec.p004a.p005a.p006a.C0084m;

/* compiled from: InitMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.b */
/* loaded from: classes.dex */
public class C1101b extends AbstractC1099a implements InterfaceC1110d {

    /* renamed from: a */
    private static final String f4047a = C1101b.class.getSimpleName();

    /* renamed from: b */
    private static boolean f4048b;

    /* renamed from: c */
    private int f4049c;

    /* renamed from: d */
    private C1087d f4050d;

    /* renamed from: e */
    private InterfaceC1108b f4051e;

    public C1101b(Context context) {
        super(context, 1L);
        this.f4050d = PushClientApplication.m4112h().m4115j();
        this.f4051e = null;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a_ */
    public Class mo4153a_() {
        return C0080i.class;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4047a, "InitMessageTask.onRequest().");
        }
        C1072b.m4118a().m4127f();
        if (!C1105f.m4164a(m4148a())) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4047a, "Provisioning isn't completed. Execute provisioning before initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1105f(m4148a()));
                return null;
            } catch (InterruptedException e) {
                if (!C1139g.f4145d) {
                    return null;
                }
                C1139g.m4309a(f4047a, e.getMessage(), e);
                return null;
            }
        }
        if (m4155d()) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4047a, "Initialization already has been completed. Don't execute re-initialize.");
            }
            if (this.f4051e == null) {
                return null;
            }
            this.f4051e.mo4171a(-102);
            return null;
        }
        try {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4047a, "Disconnect connection before initialize.");
            }
            this.f4050d.mo4140b();
        } catch (Exception e2) {
        }
        String strM4165b = C1105f.m4165b(m4148a());
        int iM4166c = C1105f.m4166c(m4148a());
        if (C1139g.f4143b) {
            C1139g.m4311b(f4047a, String.format("Connect to push server(%s:%s).", strM4165b, Integer.valueOf(iM4166c)));
        }
        try {
            this.f4050d.mo4137a(strM4165b, iM4166c, true);
        } catch (C1081k e3) {
            if (C1139g.f4145d) {
                C1139g.m4313d(f4047a, "There isn't available network in device.");
            }
            m4154a(-104);
            if (this.f4051e == null) {
                return null;
            }
            this.f4051e.mo4171a(-2);
            return null;
        } catch (C1071a e4) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4047a, "Can't connect to push server.", e4);
            }
            if (C1139g.f4143b) {
                C1139g.m4311b(f4047a, "Switch push server address.");
            }
            C1105f.m4167d();
            String strM4165b2 = C1105f.m4165b(m4148a());
            int iM4166c2 = C1105f.m4166c(m4148a());
            if (C1139g.f4143b) {
                C1139g.m4311b(f4047a, String.format("Connect to push server(%s:%s).", strM4165b2, Integer.valueOf(iM4166c2)));
            }
            try {
                this.f4050d.mo4137a(strM4165b2, iM4166c2, true);
            } catch (C1081k e5) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4047a, "There isn't available network in device.");
                }
                C1105f.m4167d();
                m4154a(-104);
                if (this.f4051e == null) {
                    return null;
                }
                this.f4051e.mo4171a(-2);
                return null;
            } catch (C1071a e6) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(f4047a, "Can't connect to push server.", e6);
                }
                C1105f.m4167d();
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4047a, "Execute re-provisioning.");
                }
                C1126j.m4249b();
                m4154a(-104);
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4047a, "Couldn't connect primary and secondary push server. execute re-provisioning.");
                }
                C1072b.m4118a().m4126e();
                if (this.f4051e == null) {
                    return null;
                }
                this.f4051e.mo4171a(-104);
                return null;
            }
        }
        this.f4049c = C1136d.m4290a();
        C0084m c0084mNewBuilder = C0083l.newBuilder();
        c0084mNewBuilder.m417a(this.f4049c);
        c0084mNewBuilder.m420a(C1126j.m4248b((String) null));
        return new C1114h().m4194a(this.f4050d).m4193a(c0084mNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a */
    public void mo4151a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4047a, String.format("InitMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            C0080i c0080i = (C0080i) generatedMessageLite;
            int iM376f = c0080i.m376f();
            if (this.f4049c != c0080i.m374d()) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4047a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f4049c), Integer.valueOf(c0080i.m374d())));
                    return;
                }
                return;
            }
            if (iM376f == 1000) {
                m4156e();
                C1072b.m4118a().m4128g();
                if (PushClientApplication.m4112h().m4114i()) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4047a, "Start HeartBeat.");
                    }
                    HeartBeat.m4218a();
                } else if (C1139g.f4142a) {
                    C1139g.m4308a(f4047a, "HeartBeat will not be started hence push service hadn't been started.");
                }
                if (this.f4051e != null) {
                    this.f4051e.mo4170a();
                    return;
                }
                return;
            }
            if (C1139g.f4145d) {
                C1139g.m4313d(f4047a, String.format("Init reply result code is error. ErrorCode: %d.", Integer.valueOf(iM376f)));
            }
            m4157f();
            m4154a(-104);
            if (iM376f == 4002 || iM376f == 4006) {
                try {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4047a, "Disconnect connection.");
                    }
                    this.f4050d.mo4140b();
                } catch (C1071a e) {
                }
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4047a, "Execute reprovisioning.");
                }
                C1126j.m4249b();
                C1072b.m4118a().m4126e();
                if (this.f4051e != null) {
                    this.f4051e.mo4171a(-104);
                    return;
                }
                return;
            }
            if (iM376f == 2002) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4047a, "Server error: internal server error.");
                }
                if (C1105f.m4168e() == EnumC1106g.Primary) {
                    try {
                        if (C1139g.f4142a) {
                            C1139g.m4308a(f4047a, "Disconnect connection.");
                        }
                        this.f4050d.mo4140b();
                    } catch (C1071a e2) {
                    }
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4047a, "Retry initialize using secondary push server.");
                    }
                    C1105f.m4167d();
                    C1072b.m4118a().m4126e();
                    if (this.f4051e != null) {
                        this.f4051e.mo4171a(-104);
                        return;
                    }
                    return;
                }
                if (C1105f.m4168e() == EnumC1106g.Secondary) {
                    try {
                        if (C1139g.f4142a) {
                            C1139g.m4308a(f4047a, "Disconnect connection.");
                        }
                        this.f4050d.mo4140b();
                    } catch (C1071a e3) {
                    }
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4047a, "Execute re-provisioning.");
                    }
                    C1126j.m4249b();
                    C1072b.m4118a().m4126e();
                    if (this.f4051e != null) {
                        this.f4051e.mo4171a(-104);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iM376f == 2003) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4047a, "Server error: interrupted.");
                }
                try {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4047a, "Disconnect connection.");
                    }
                    this.f4050d.mo4140b();
                } catch (C1071a e4) {
                }
                C1072b.m4118a().m4126e();
                if (this.f4051e != null) {
                    this.f4051e.mo4171a(-104);
                    return;
                }
                return;
            }
            return;
        }
        m4157f();
        m4154a(-104);
        if (i == -1) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4047a, "Internal error code is timeout.");
            }
            try {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4047a, "Disconnect connection.");
                }
                this.f4050d.mo4140b();
            } catch (C1071a e5) {
            }
            C1072b.m4118a().m4126e();
        }
        if (this.f4051e != null) {
            this.f4051e.mo4171a(-104);
        }
    }

    /* renamed from: a */
    private void m4154a(int i) {
        C1072b.m4118a().m4121a(i);
    }

    /* renamed from: d */
    public static synchronized boolean m4155d() {
        if (f4048b && !PushClientApplication.m4112h().m4115j().m4141c()) {
            f4048b = false;
        }
        return f4048b;
    }

    /* renamed from: e */
    public static synchronized void m4156e() {
        f4048b = true;
    }

    /* renamed from: f */
    public static synchronized void m4157f() {
        f4048b = false;
    }
}
