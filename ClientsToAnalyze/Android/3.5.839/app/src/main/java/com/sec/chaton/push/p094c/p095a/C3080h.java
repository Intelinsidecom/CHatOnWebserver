package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.C3087h;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.p094c.InterfaceC3083d;
import com.sec.chaton.push.util.C3112d;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;
import com.sec.p043a.p044a.p045a.C0743aj;
import com.sec.p043a.p044a.p045a.C0746am;
import com.sec.p043a.p044a.p045a.C0747an;

/* compiled from: RegistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.h */
/* loaded from: classes.dex */
public class C3080h extends AbstractC3072a implements InterfaceC3083d {

    /* renamed from: a */
    private static final String f11382a = AbstractC3072a.class.getSimpleName();

    /* renamed from: b */
    private int f11383b;

    /* renamed from: c */
    private String f11384c;

    /* renamed from: d */
    private C3060d f11385d;

    /* renamed from: e */
    private InterfaceC3081b f11386e;

    public C3080h(Context context, String str) {
        super(context, 2L);
        this.f11384c = str;
        this.f11385d = ((PushClientApplication) CommonApplication.m18732r()).m12502p();
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: n_ */
    public Class<? extends GeneratedMessageLite> mo12540n_() {
        return C0743aj.class;
    }

    /* renamed from: a */
    public void m12557a(InterfaceC3081b interfaceC3081b) {
        this.f11386e = interfaceC3081b;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11382a, "RegistrationMessageTask.onRequest().");
        }
        if (!C3074b.m12543d()) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11382a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3074b(m12535a()));
                C3088i.m12584a().m12591a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C3115g.f11461d) {
                    return null;
                }
                C3115g.m12702a(f11382a, e.getMessage(), e);
                return null;
            }
        }
        this.f11383b = C3112d.m12683a();
        C0747an c0747anNewBuilder = C0746am.newBuilder();
        c0747anNewBuilder.m2516a(this.f11383b);
        c0747anNewBuilder.m2519a(C3099k.m12635b((String) null));
        c0747anNewBuilder.m2521b(this.f11384c);
        c0747anNewBuilder.m2523c("");
        return new C3087h().m12582a(this.f11385d).m12581a(c0747anNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: a */
    public void mo12538a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11382a, String.format("RegistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11382a, "Response message is null.");
                    return;
                }
                return;
            }
            C0743aj c0743aj = (C0743aj) generatedMessageLite;
            int iM2461f = c0743aj.m2461f();
            if (this.f11383b != c0743aj.m2459d()) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11382a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f11383b), Integer.valueOf(c0743aj.m2459d())));
                    return;
                }
                return;
            }
            if (iM2461f == 1000) {
                SharedPreferences.Editor editorM12627a = C3099k.m12627a();
                C3099k.m12632a(editorM12627a, this.f11384c);
                C3099k.m12638b(editorM12627a, c0743aj.m2465j());
                editorM12627a.commit();
                m12535a().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f11386e != null) {
                    this.f11386e.mo12558a();
                    return;
                }
                return;
            }
            if (C3115g.f11461d) {
                C3115g.m12706d(f11382a, String.format("Registration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM2461f)));
            }
            if (iM2461f == 4002) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11382a, "Server error: empty device token.");
                    C3115g.m12706d(f11382a, "Close connection.");
                }
                try {
                    this.f11385d.mo12527b();
                } catch (C3044a e) {
                }
                C3099k.m12636b();
                C3045b.m12505a().m12513e();
                if (this.f11386e != null) {
                    this.f11386e.mo12559a(iM2461f);
                    return;
                }
                return;
            }
            if (iM2461f == 4003) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11382a, "Server error: empty application id.");
                    C3115g.m12706d(f11382a, "Do not anything.");
                }
                try {
                    this.f11385d.mo12527b();
                } catch (C3044a e2) {
                }
                C3045b.m12505a().m12513e();
                if (this.f11386e != null) {
                    this.f11386e.mo12559a(iM2461f);
                    return;
                }
                return;
            }
            if (iM2461f == 4001) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11382a, "Server error: empty device token.");
                    C3115g.m12706d(f11382a, "Close connection.");
                }
                try {
                    this.f11385d.mo12527b();
                } catch (C3044a e3) {
                }
                C3045b.m12505a().m12513e();
                if (this.f11386e != null) {
                    this.f11386e.mo12559a(iM2461f);
                    return;
                }
                return;
            }
            if (iM2461f == 4007) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11382a, "Server error: registration failed.");
                    C3115g.m12706d(f11382a, "Do not anything.");
                }
                if (this.f11386e != null) {
                    this.f11386e.mo12559a(iM2461f);
                    return;
                }
                return;
            }
            if (this.f11386e != null) {
                this.f11386e.mo12559a(iM2461f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11382a, "Internal error code is timeout.");
            }
            try {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11382a, "Disconnect connection.");
                }
                this.f11385d.mo12527b();
            } catch (C3044a e4) {
            }
            C3045b.m12505a().m12513e();
        }
        if (this.f11386e != null) {
            this.f11386e.mo12559a(i);
        }
    }
}
