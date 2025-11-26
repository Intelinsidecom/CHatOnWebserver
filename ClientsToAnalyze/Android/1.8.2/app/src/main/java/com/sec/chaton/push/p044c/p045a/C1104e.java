package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.C1114h;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.p044c.InterfaceC1110d;
import com.sec.chaton.push.util.C1136d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0057aa;
import com.sec.p004a.p005a.p006a.C0058ab;
import com.sec.p004a.p005a.p006a.C0095x;

/* compiled from: PingMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.e */
/* loaded from: classes.dex */
public class C1104e extends AbstractC1099a implements InterfaceC1110d {

    /* renamed from: a */
    private static final String f4058a = C1104e.class.getSimpleName();

    /* renamed from: b */
    private int f4059b;

    /* renamed from: c */
    private C1087d f4060c;

    /* renamed from: d */
    private InterfaceC1108b f4061d;

    public C1104e(Context context) {
        super(context, 2L);
        this.f4060c = PushClientApplication.m4112h().m4115j();
    }

    /* renamed from: a */
    public void m4162a(InterfaceC1108b interfaceC1108b) {
        this.f4061d = interfaceC1108b;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a_ */
    public Class mo4153a_() {
        return C0095x.class;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4058a, "PingMessageTask.onRequest().");
        }
        if (!C1101b.m4155d()) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4058a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1101b(m4148a()));
                C1115i.m4196a().m4203a(this);
            } catch (InterruptedException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(f4058a, e.getMessage(), e);
                }
            }
            return null;
        }
        this.f4059b = C1136d.m4290a();
        C0058ab c0058abNewBuilder = C0057aa.newBuilder();
        c0058abNewBuilder.m90a(this.f4059b);
        c0058abNewBuilder.m91a(System.currentTimeMillis());
        c0058abNewBuilder.m95b(C1126j.m4253c(8));
        return new C1114h().m4194a(this.f4060c).m4193a(c0058abNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a */
    public void mo4151a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4058a, String.format("PingMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            C0095x c0095x = (C0095x) generatedMessageLite;
            if (this.f4059b != c0095x.m556d()) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4058a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f4059b), Integer.valueOf(c0095x.m556d())));
                    return;
                }
                return;
            } else {
                if (this.f4061d != null) {
                    this.f4061d.mo4170a();
                    return;
                }
                return;
            }
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4058a, "Close connection.");
        }
        try {
            this.f4060c.mo4140b();
        } catch (C1071a e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4058a, e.getMessage(), e);
            }
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4058a, "Execeute initialize.");
        }
        try {
            C1115i.m4196a().m4203a(new C1101b(PushClientApplication.m4111g()));
        } catch (InterruptedException e2) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4058a, e2.getMessage(), e2);
            }
        }
        if (this.f4061d != null) {
            this.f4061d.mo4171a(i);
        }
    }
}
