package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
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
import com.sec.p004a.p005a.p006a.C0066aj;
import com.sec.p004a.p005a.p006a.C0069am;
import com.sec.p004a.p005a.p006a.C0070an;

/* compiled from: RegistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.h */
/* loaded from: classes.dex */
public class C1107h extends AbstractC1099a implements InterfaceC1110d {

    /* renamed from: a */
    private static final String f4069a = AbstractC1099a.class.getSimpleName();

    /* renamed from: b */
    private int f4070b;

    /* renamed from: c */
    private String f4071c;

    /* renamed from: d */
    private C1087d f4072d;

    /* renamed from: e */
    private InterfaceC1108b f4073e;

    public C1107h(Context context, String str) {
        super(context, 2L);
        this.f4071c = str;
        this.f4072d = ((PushClientApplication) PushClientApplication.m4111g()).m4115j();
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a_ */
    public Class mo4153a_() {
        return C0066aj.class;
    }

    /* renamed from: a */
    public void m4169a(InterfaceC1108b interfaceC1108b) {
        this.f4073e = interfaceC1108b;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4069a, "RegistrationMessageTask.onRequest().");
        }
        if (!C1101b.m4155d()) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4069a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1101b(m4148a()));
                C1115i.m4196a().m4203a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C1139g.f4145d) {
                    return null;
                }
                C1139g.m4309a(f4069a, e.getMessage(), e);
                return null;
            }
        }
        this.f4070b = C1136d.m4290a();
        C0070an c0070anNewBuilder = C0069am.newBuilder();
        c0070anNewBuilder.m272a(this.f4070b);
        c0070anNewBuilder.m275a(C1126j.m4248b((String) null));
        c0070anNewBuilder.m277b(this.f4071c);
        c0070anNewBuilder.m279c("");
        return new C1114h().m4194a(this.f4072d).m4193a(c0070anNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a */
    public void mo4151a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4069a, String.format("RegistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            C0066aj c0066aj = (C0066aj) generatedMessageLite;
            int iM217f = c0066aj.m217f();
            if (this.f4070b != c0066aj.m215d()) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4069a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f4070b), Integer.valueOf(c0066aj.m215d())));
                    return;
                }
                return;
            }
            if (iM217f == 1000) {
                SharedPreferences.Editor editorM4240a = C1126j.m4240a();
                C1126j.m4252b(editorM4240a, this.f4071c);
                C1126j.m4256c(editorM4240a, c0066aj.m221j());
                editorM4240a.commit();
                m4148a().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f4073e != null) {
                    this.f4073e.mo4170a();
                    return;
                }
                return;
            }
            if (C1139g.f4145d) {
                C1139g.m4313d(f4069a, String.format("Registration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM217f)));
            }
            if (iM217f == 4002) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4069a, "Server error: empty device token.");
                    C1139g.m4313d(f4069a, "Close connection.");
                }
                try {
                    this.f4072d.mo4140b();
                } catch (C1071a e) {
                }
                C1126j.m4249b();
                C1072b.m4118a().m4126e();
                if (this.f4073e != null) {
                    this.f4073e.mo4171a(iM217f);
                    return;
                }
                return;
            }
            if (iM217f == 4003) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4069a, "Server error: empty application id.");
                    C1139g.m4313d(f4069a, "Do not anything.");
                }
                try {
                    this.f4072d.mo4140b();
                } catch (C1071a e2) {
                }
                C1072b.m4118a().m4126e();
                if (this.f4073e != null) {
                    this.f4073e.mo4171a(iM217f);
                    return;
                }
                return;
            }
            if (iM217f == 4001) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4069a, "Server error: empty device token.");
                    C1139g.m4313d(f4069a, "Close connection.");
                }
                try {
                    this.f4072d.mo4140b();
                } catch (C1071a e3) {
                }
                C1072b.m4118a().m4126e();
                if (this.f4073e != null) {
                    this.f4073e.mo4171a(iM217f);
                    return;
                }
                return;
            }
            if (iM217f == 4007) {
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4069a, "Server error: registration failed.");
                    C1139g.m4313d(f4069a, "Do not anything.");
                }
                if (this.f4073e != null) {
                    this.f4073e.mo4171a(iM217f);
                    return;
                }
                return;
            }
            if (this.f4073e != null) {
                this.f4073e.mo4171a(iM217f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4069a, "Internal error code is timeout.");
            }
            try {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4069a, "Disconnect connection.");
                }
                this.f4072d.mo4140b();
            } catch (C1071a e4) {
            }
            C1072b.m4118a().m4126e();
        }
        if (this.f4073e != null) {
            this.f4073e.mo4171a(i);
        }
    }
}
