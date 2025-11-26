package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.p137vk.sdk.api.VKError;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p090a.C3054k;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.C3087h;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.p094c.InterfaceC3083d;
import com.sec.chaton.push.util.C3112d;
import com.sec.chaton.push.util.C3113e;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;
import com.sec.p043a.p044a.p045a.C0757i;
import com.sec.p043a.p044a.p045a.C0760l;
import com.sec.p043a.p044a.p045a.C0761m;

/* compiled from: InitMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.b */
/* loaded from: classes.dex */
public class C3074b extends AbstractC3072a implements InterfaceC3083d {

    /* renamed from: a */
    private static final String f11359a = C3074b.class.getSimpleName();

    /* renamed from: b */
    private static boolean f11360b;

    /* renamed from: c */
    private int f11361c;

    /* renamed from: d */
    private C3060d f11362d;

    /* renamed from: e */
    private InterfaceC3081b f11363e;

    public C3074b(Context context) {
        super(context, 1L);
        this.f11362d = PushClientApplication.m12499n().m12502p();
        this.f11363e = null;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: n_ */
    public Class<? extends GeneratedMessageLite> mo12540n_() {
        return C0757i.class;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11359a, "InitMessageTask.onRequest().");
        }
        C3045b.m12505a().m12514f();
        if (C3113e.m12697a() == EnumC3114f.Mobile) {
            String strM12698b = C3113e.m12698b();
            String strM12657h = C3099k.m12657h((String) null);
            if (strM12698b == null || !strM12698b.equals(strM12657h)) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "The network operator is changed. New(" + strM12698b + "), Old(" + strM12657h + ").");
                    C3115g.m12701a(f11359a, "Execute re-provisioning.");
                }
                C3099k.m12636b();
                C3099k.m12641c();
            }
        }
        if (!C3078f.m12552a(m12535a())) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11359a, "Provisioning isn't completed. Execute provisioning before initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3078f(m12535a()));
                return null;
            } catch (InterruptedException e) {
                if (!C3115g.f11461d) {
                    return null;
                }
                C3115g.m12702a(f11359a, e.getMessage(), e);
                return null;
            }
        }
        if (m12543d()) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11359a, "Initialization already has been completed. Don't execute re-initialize.");
            }
            if (this.f11363e == null) {
                return null;
            }
            this.f11363e.mo12559a(VKError.VK_API_CANCELED);
            return null;
        }
        try {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11359a, "Disconnect connection before initialize.");
            }
            this.f11362d.mo12527b();
        } catch (Exception e2) {
        }
        String strM12553b = C3078f.m12553b(m12535a());
        int iM12554c = C3078f.m12554c(m12535a());
        if (C3115g.f11459b) {
            C3115g.m12704b(f11359a, String.format("Connect to push server(%s:%s).", strM12553b, Integer.valueOf(iM12554c)));
        }
        try {
            this.f11362d.mo12523a(strM12553b, iM12554c, true);
        } catch (C3054k e3) {
            if (C3115g.f11461d) {
                C3115g.m12706d(f11359a, "There isn't available network in device.");
            }
            m12541a(VKError.VK_API_JSON_FAILED);
            if (this.f11363e == null) {
                return null;
            }
            this.f11363e.mo12559a(-2);
            return null;
        } catch (C3044a e4) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11359a, "Can't connect to push server.", e4);
            }
            if (C3115g.f11459b) {
                C3115g.m12704b(f11359a, "Switch push server address.");
            }
            C3078f.m12555d();
            String strM12553b2 = C3078f.m12553b(m12535a());
            int iM12554c2 = C3078f.m12554c(m12535a());
            if (C3115g.f11459b) {
                C3115g.m12704b(f11359a, String.format("Connect to push server(%s:%s).", strM12553b2, Integer.valueOf(iM12554c2)));
            }
            try {
                this.f11362d.mo12523a(strM12553b2, iM12554c2, true);
            } catch (C3054k e5) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11359a, "There isn't available network in device.");
                }
                C3078f.m12555d();
                m12541a(VKError.VK_API_JSON_FAILED);
                if (this.f11363e == null) {
                    return null;
                }
                this.f11363e.mo12559a(-2);
                return null;
            } catch (C3044a e6) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(f11359a, "Can't connect to push server.", e6);
                }
                C3078f.m12555d();
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "Execute re-provisioning.");
                }
                C3099k.m12636b();
                m12541a(VKError.VK_API_JSON_FAILED);
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "Couldn't connect primary and secondary push server. execute re-provisioning.");
                }
                C3045b.m12505a().m12513e();
                if (this.f11363e == null) {
                    return null;
                }
                this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
                return null;
            }
        }
        this.f11361c = C3112d.m12683a();
        C0761m c0761mNewBuilder = C0760l.newBuilder();
        c0761mNewBuilder.m2661a(this.f11361c);
        c0761mNewBuilder.m2664a(C3099k.m12635b((String) null));
        return new C3087h().m12582a(this.f11362d).m12581a(c0761mNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: a */
    public void mo12538a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11359a, String.format("InitMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11359a, "Response message is null.");
                    return;
                }
                return;
            }
            C0757i c0757i = (C0757i) generatedMessageLite;
            int iM2620f = c0757i.m2620f();
            if (this.f11361c != c0757i.m2618d()) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11359a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f11361c), Integer.valueOf(c0757i.m2618d())));
                    return;
                }
                return;
            }
            if (iM2620f == 1000) {
                m12544e();
                C3045b.m12505a().m12515g();
                if (PushClientApplication.m12499n().m12501o()) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11359a, "Start HeartBeat.");
                    }
                    HeartBeat.m12608c();
                } else if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "HeartBeat will not be started hence push service hadn't been started.");
                }
                if (this.f11363e != null) {
                    this.f11363e.mo12558a();
                    return;
                }
                return;
            }
            if (C3115g.f11461d) {
                C3115g.m12706d(f11359a, String.format("Init reply result code is error. ErrorCode: %d.", Integer.valueOf(iM2620f)));
            }
            m12545f();
            m12541a(VKError.VK_API_JSON_FAILED);
            if (iM2620f == 4002 || iM2620f == 4006) {
                try {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11359a, "Disconnect connection.");
                    }
                    this.f11362d.mo12527b();
                } catch (C3044a e) {
                }
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "Execute reprovisioning.");
                }
                C3099k.m12636b();
                C3045b.m12505a().m12513e();
                if (this.f11363e != null) {
                    this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
                    return;
                }
                return;
            }
            if (iM2620f == 2002) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11359a, "Server error: internal server error.");
                }
                if (C3078f.m12556e() == EnumC3079g.Primary) {
                    try {
                        if (C3115g.f11458a) {
                            C3115g.m12701a(f11359a, "Disconnect connection.");
                        }
                        this.f11362d.mo12527b();
                    } catch (C3044a e2) {
                    }
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11359a, "Retry initialize using secondary push server.");
                    }
                    C3078f.m12555d();
                    C3045b.m12505a().m12513e();
                    if (this.f11363e != null) {
                        this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
                        return;
                    }
                    return;
                }
                if (C3078f.m12556e() == EnumC3079g.Secondary) {
                    try {
                        if (C3115g.f11458a) {
                            C3115g.m12701a(f11359a, "Disconnect connection.");
                        }
                        this.f11362d.mo12527b();
                    } catch (C3044a e3) {
                    }
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11359a, "Execute re-provisioning.");
                    }
                    C3099k.m12636b();
                    C3045b.m12505a().m12513e();
                    if (this.f11363e != null) {
                        this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iM2620f == 2003) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11359a, "Server error: interrupted.");
                }
                try {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11359a, "Disconnect connection.");
                    }
                    this.f11362d.mo12527b();
                } catch (C3044a e4) {
                }
                C3045b.m12505a().m12513e();
                if (this.f11363e != null) {
                    this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
                    return;
                }
                return;
            }
            return;
        }
        m12545f();
        m12541a(VKError.VK_API_JSON_FAILED);
        if (i == -1) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11359a, "Internal error code is timeout.");
            }
            try {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11359a, "Disconnect connection.");
                }
                this.f11362d.mo12527b();
            } catch (C3044a e5) {
            }
            C3045b.m12505a().m12513e();
        }
        if (this.f11363e != null) {
            this.f11363e.mo12559a(VKError.VK_API_JSON_FAILED);
        }
    }

    /* renamed from: a */
    private void m12541a(int i) {
        C3045b.m12505a().m12508a(i);
    }

    /* renamed from: a */
    public static synchronized boolean m12542a(boolean z) {
        if (f11360b && !PushClientApplication.m12499n().m12502p().m12526a(z)) {
            f11360b = false;
        }
        return f11360b;
    }

    /* renamed from: d */
    public static synchronized boolean m12543d() {
        return m12542a(true);
    }

    /* renamed from: e */
    public static synchronized void m12544e() {
        f11360b = true;
    }

    /* renamed from: f */
    public static synchronized void m12545f() {
        f11360b = false;
    }
}
