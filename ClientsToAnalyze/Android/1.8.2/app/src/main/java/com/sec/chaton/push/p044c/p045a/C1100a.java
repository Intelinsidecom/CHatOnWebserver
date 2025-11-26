package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.C1114h;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.p044c.InterfaceC1110d;
import com.sec.chaton.push.util.C1136d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0074c;
import com.sec.p004a.p005a.p006a.C0077f;
import com.sec.p004a.p005a.p006a.C0078g;

/* compiled from: DeregistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.a */
/* loaded from: classes.dex */
public class C1100a extends AbstractC1099a implements InterfaceC1110d {

    /* renamed from: a */
    private static final String f4042a = C1100a.class.getSimpleName();

    /* renamed from: b */
    private int f4043b;

    /* renamed from: c */
    private String f4044c;

    /* renamed from: d */
    private C1087d f4045d;

    /* renamed from: e */
    private InterfaceC1108b f4046e;

    public C1100a(Context context, String str) {
        super(context, 2L);
        this.f4044c = str;
        this.f4045d = PushClientApplication.m4112h().m4115j();
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a_ */
    public Class mo4153a_() {
        return C0074c.class;
    }

    /* renamed from: a */
    public void m4152a(InterfaceC1108b interfaceC1108b) {
        this.f4046e = interfaceC1108b;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4042a, "DeregistrationMessageTask.onRequest().");
        }
        String strM4262e = C1126j.m4262e((String) null);
        if (strM4262e == null || !strM4262e.equals(this.f4044c)) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4042a, String.format("The application(id:%s) had been deregistered. callback success to application without networking.", this.f4044c));
            }
            if (this.f4046e == null) {
                return null;
            }
            this.f4046e.mo4170a();
            return null;
        }
        if (!C1101b.m4155d()) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4042a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1101b(m4148a()));
                C1115i.m4196a().m4203a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C1139g.f4145d) {
                    return null;
                }
                C1139g.m4309a(f4042a, e.getMessage(), e);
                return null;
            }
        }
        this.f4043b = C1136d.m4290a();
        C0078g c0078gNewBuilder = C0077f.newBuilder();
        c0078gNewBuilder.m353a(this.f4043b);
        c0078gNewBuilder.m356a(C1126j.m4248b((String) null));
        c0078gNewBuilder.m358b(C1126j.m4264f((String) null));
        c0078gNewBuilder.m360c("");
        return new C1114h().m4194a(this.f4045d).m4193a(c0078gNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a */
    public void mo4151a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4042a, String.format("DeregistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            C0074c c0074c = (C0074c) generatedMessageLite;
            int iM301f = c0074c.m301f();
            if (this.f4043b != c0074c.m299d()) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4042a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f4043b), Integer.valueOf(c0074c.m299d())));
                    return;
                }
                return;
            }
            if (iM301f == 1000) {
                SharedPreferences.Editor editorM4240a = C1126j.m4240a();
                C1126j.m4267g(editorM4240a);
                C1126j.m4269h(editorM4240a);
                editorM4240a.commit();
                try {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4042a, "Close connection.");
                    }
                    this.f4045d.mo4140b();
                } catch (C1071a e) {
                }
                HeartBeat.m4220b();
                m4148a().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f4046e != null) {
                    this.f4046e.mo4170a();
                    return;
                }
                return;
            }
            if (C1139g.f4145d) {
                C1139g.m4313d(f4042a, String.format("Deregistration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM301f)));
            }
            if (iM301f == 4002 || iM301f == 4009) {
                if (C1139g.f4145d) {
                    if (iM301f == 4002) {
                        if (C1139g.f4145d) {
                            C1139g.m4313d(f4042a, "Server error: empty device token.");
                        }
                    } else if (iM301f == 4009 && C1139g.f4145d) {
                        C1139g.m4313d(f4042a, "Server error: wrong device token.");
                    }
                }
                try {
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4042a, "Close connection.");
                    }
                    this.f4045d.mo4140b();
                } catch (C1071a e2) {
                }
                C1126j.m4249b();
                C1072b.m4118a().m4126e();
                if (this.f4046e != null) {
                    this.f4046e.mo4171a(iM301f);
                    return;
                }
                return;
            }
            if (iM301f == 4004) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4042a, "Server error: empty application id.");
                    C1139g.m4313d(f4042a, "Do not anything.");
                }
                if (this.f4046e != null) {
                    this.f4046e.mo4171a(iM301f);
                    return;
                }
                return;
            }
            if (iM301f == 4001) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4042a, "Server error: invalid state.");
                    C1139g.m4313d(f4042a, "Close connection.");
                }
                try {
                    this.f4045d.mo4140b();
                } catch (C1071a e3) {
                }
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4042a, "Execute initialization.");
                }
                C1072b.m4118a().m4126e();
                if (this.f4046e != null) {
                    this.f4046e.mo4171a(iM301f);
                    return;
                }
                return;
            }
            if (iM301f == 4008) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4042a, "Server error: invalid state.");
                    C1139g.m4313d(f4042a, "Close connection.");
                }
                if (this.f4046e != null) {
                    this.f4046e.mo4171a(iM301f);
                    return;
                }
                return;
            }
            if (this.f4046e != null) {
                this.f4046e.mo4171a(iM301f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4042a, "Internal error code is timeout.");
            }
            try {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4042a, "Disconnect connection.");
                }
                this.f4045d.mo4140b();
            } catch (C1071a e4) {
            }
            C1072b.m4118a().m4126e();
        }
        if (this.f4046e != null) {
            this.f4046e.mo4171a(i);
        }
    }
}
