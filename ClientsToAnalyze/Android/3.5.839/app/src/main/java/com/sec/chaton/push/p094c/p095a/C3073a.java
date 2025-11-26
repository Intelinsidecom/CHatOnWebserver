package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
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
import com.sec.p043a.p044a.p045a.C0751c;
import com.sec.p043a.p044a.p045a.C0754f;
import com.sec.p043a.p044a.p045a.C0755g;

/* compiled from: DeregistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.a */
/* loaded from: classes.dex */
public class C3073a extends AbstractC3072a implements InterfaceC3083d {

    /* renamed from: a */
    private static final String f11354a = C3073a.class.getSimpleName();

    /* renamed from: b */
    private int f11355b;

    /* renamed from: c */
    private String f11356c;

    /* renamed from: d */
    private C3060d f11357d;

    /* renamed from: e */
    private InterfaceC3081b f11358e;

    public C3073a(Context context, String str) {
        super(context, 2L);
        this.f11356c = str;
        this.f11357d = PushClientApplication.m12499n().m12502p();
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: n_ */
    public Class<? extends GeneratedMessageLite> mo12540n_() {
        return C0751c.class;
    }

    /* renamed from: a */
    public void m12539a(InterfaceC3081b interfaceC3081b) {
        this.f11358e = interfaceC3081b;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11354a, "DeregistrationMessageTask.onRequest().");
        }
        String strM12648e = C3099k.m12648e((String) null);
        if (strM12648e == null || !strM12648e.equals(this.f11356c)) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11354a, String.format("The application(id:%s) had been deregistered. callback success to application without networking.", this.f11356c));
            }
            if (this.f11358e == null) {
                return null;
            }
            this.f11358e.mo12558a();
            return null;
        }
        if (!C3074b.m12543d()) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11354a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3074b(m12535a()));
                C3088i.m12584a().m12591a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C3115g.f11461d) {
                    return null;
                }
                C3115g.m12702a(f11354a, e.getMessage(), e);
                return null;
            }
        }
        this.f11355b = C3112d.m12683a();
        C0755g c0755gNewBuilder = C0754f.newBuilder();
        c0755gNewBuilder.m2597a(this.f11355b);
        c0755gNewBuilder.m2600a(C3099k.m12635b((String) null));
        c0755gNewBuilder.m2602b(C3099k.m12651f((String) null));
        c0755gNewBuilder.m2604c("");
        return new C3087h().m12582a(this.f11357d).m12581a(c0755gNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: a */
    public void mo12538a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11354a, String.format("DeregistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11354a, "Response message is null.");
                    return;
                }
                return;
            }
            C0751c c0751c = (C0751c) generatedMessageLite;
            int iM2545f = c0751c.m2545f();
            if (this.f11355b != c0751c.m2543d()) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11354a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f11355b), Integer.valueOf(c0751c.m2543d())));
                    return;
                }
                return;
            }
            if (iM2545f == 1000) {
                SharedPreferences.Editor editorM12627a = C3099k.m12627a();
                C3099k.m12661j(editorM12627a);
                C3099k.m12662k(editorM12627a);
                editorM12627a.commit();
                try {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11354a, "Close connection.");
                    }
                    this.f11357d.mo12527b();
                } catch (C3044a e) {
                }
                HeartBeat.m12609d();
                m12535a().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f11358e != null) {
                    this.f11358e.mo12558a();
                    return;
                }
                return;
            }
            if (C3115g.f11461d) {
                C3115g.m12706d(f11354a, String.format("Deregistration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM2545f)));
            }
            if (iM2545f == 4002 || iM2545f == 4009) {
                if (C3115g.f11461d) {
                    if (iM2545f == 4002) {
                        if (C3115g.f11461d) {
                            C3115g.m12706d(f11354a, "Server error: empty device token.");
                        }
                    } else if (iM2545f == 4009 && C3115g.f11461d) {
                        C3115g.m12706d(f11354a, "Server error: wrong device token.");
                    }
                }
                try {
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11354a, "Close connection.");
                    }
                    this.f11357d.mo12527b();
                } catch (C3044a e2) {
                }
                C3099k.m12636b();
                C3045b.m12505a().m12513e();
                if (this.f11358e != null) {
                    this.f11358e.mo12559a(iM2545f);
                    return;
                }
                return;
            }
            if (iM2545f == 4004) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11354a, "Server error: empty application id.");
                    C3115g.m12706d(f11354a, "Do not anything.");
                }
                if (this.f11358e != null) {
                    this.f11358e.mo12559a(iM2545f);
                    return;
                }
                return;
            }
            if (iM2545f == 4001) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11354a, "Server error: invalid state.");
                    C3115g.m12706d(f11354a, "Close connection.");
                }
                try {
                    this.f11357d.mo12527b();
                } catch (C3044a e3) {
                }
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11354a, "Execute initialization.");
                }
                C3045b.m12505a().m12513e();
                if (this.f11358e != null) {
                    this.f11358e.mo12559a(iM2545f);
                    return;
                }
                return;
            }
            if (iM2545f == 4008) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11354a, "Server error: invalid state.");
                    C3115g.m12706d(f11354a, "Close connection.");
                }
                if (this.f11358e != null) {
                    this.f11358e.mo12559a(iM2545f);
                    return;
                }
                return;
            }
            if (this.f11358e != null) {
                this.f11358e.mo12559a(iM2545f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11354a, "Internal error code is timeout.");
            }
            try {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11354a, "Disconnect connection.");
                }
                this.f11357d.mo12527b();
            } catch (C3044a e4) {
            }
            C3045b.m12505a().m12513e();
        }
        if (this.f11358e != null) {
            this.f11358e.mo12559a(i);
        }
    }
}
