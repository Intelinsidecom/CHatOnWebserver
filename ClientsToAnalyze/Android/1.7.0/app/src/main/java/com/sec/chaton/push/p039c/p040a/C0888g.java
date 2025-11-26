package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0874g;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.C0881a;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0890b;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0919e;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0067aa;
import com.sec.p004a.p005a.p006a.C0084c;
import com.sec.p004a.p005a.p006a.C0092k;

/* compiled from: InitMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.g */
/* loaded from: classes.dex */
public class C0888g extends AbstractC0894f implements InterfaceC0890b {

    /* renamed from: a */
    private static final String f3044a = C0888g.class.getSimpleName();

    /* renamed from: b */
    private static boolean f3045b;

    /* renamed from: c */
    private int f3046c;

    /* renamed from: d */
    private C0866d f3047d;

    /* renamed from: e */
    private InterfaceC0898j f3048e;

    public C0888g(Context context) {
        super(context, 1L);
        this.f3047d = PushClientApplication.m3437b().m3440d();
        this.f3048e = null;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: c */
    public Class mo3487c() {
        return C0084c.class;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3044a, "InitMessageTask.onRequest().");
        }
        C0879l.m3463a().m3472f();
        if (!C0882a.m3482a(m3518e())) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3044a, "Provisioning isn't completed. Execute provisioning before initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0882a(m3518e()));
                return null;
            } catch (InterruptedException e) {
                if (!C0921g.f3119d) {
                    return null;
                }
                C0921g.m3638a(f3044a, e.getMessage(), e);
                return null;
            }
        }
        if (m3496a()) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3044a, "Initialization already has been completed. Don't execute re-initialize.");
            }
            if (this.f3048e == null) {
                return null;
            }
            this.f3048e.mo3532a(-102);
            return null;
        }
        try {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3044a, "Disconnect connection before initialize.");
            }
            this.f3047d.mo3457b();
        } catch (Exception e2) {
        }
        String strM3484b = C0882a.m3484b(m3518e());
        int iM3485c = C0882a.m3485c(m3518e());
        if (C0921g.f3117b) {
            C0921g.m3640b(f3044a, String.format("Connect to push server(%s:%s).", strM3484b, Integer.valueOf(iM3485c)));
        }
        try {
            this.f3047d.mo3455a(strM3484b, iM3485c, true);
        } catch (C0874g e3) {
            if (C0921g.f3119d) {
                C0921g.m3642d(f3044a, "There isn't available network in device.");
            }
            m3495a(-104);
            if (this.f3048e == null) {
                return null;
            }
            this.f3048e.mo3532a(-2);
            return null;
        } catch (C0872e e4) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3044a, "Can't connect to push server.", e4);
            }
            if (C0921g.f3117b) {
                C0921g.m3640b(f3044a, "Switch push server address.");
            }
            C0882a.m3480a();
            String strM3484b2 = C0882a.m3484b(m3518e());
            int iM3485c2 = C0882a.m3485c(m3518e());
            if (C0921g.f3117b) {
                C0921g.m3640b(f3044a, String.format("Connect to push server(%s:%s).", strM3484b2, Integer.valueOf(iM3485c2)));
            }
            try {
                this.f3047d.mo3455a(strM3484b2, iM3485c2, true);
            } catch (C0874g e5) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3044a, "There isn't available network in device.");
                }
                C0882a.m3480a();
                m3495a(-104);
                if (this.f3048e == null) {
                    return null;
                }
                this.f3048e.mo3532a(-2);
                return null;
            } catch (C0872e e6) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(f3044a, "Can't connect to push server.", e6);
                }
                C0882a.m3480a();
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3044a, "Execute re-provisioning.");
                }
                C0904h.m3547b();
                m3495a(-104);
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3044a, "Couldn't connect primary and secondary push server. execute re-provisioning.");
                }
                C0879l.m3463a().m3471e();
                if (this.f3048e == null) {
                    return null;
                }
                this.f3048e.mo3532a(-104);
                return null;
            }
        }
        this.f3046c = C0919e.m3620a();
        C0067aa c0067aaNewBuilder = C0092k.newBuilder();
        c0067aaNewBuilder.m96a(this.f3046c);
        c0067aaNewBuilder.m99a(C0904h.m3546b((String) null));
        return new C0881a().m3478a(this.f3047d).m3477a(c0067aaNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: a */
    public void mo3486a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3044a, String.format("InitMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3044a, "Response message is null.");
                    return;
                }
                return;
            }
            C0084c c0084c = (C0084c) generatedMessageLite;
            int iM341f = c0084c.m341f();
            if (this.f3046c != c0084c.m339d()) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3044a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f3046c), Integer.valueOf(c0084c.m339d())));
                    return;
                }
                return;
            }
            if (iM341f == 1000) {
                m3497b();
                C0879l.m3463a().m3473g();
                if (PushClientApplication.m3437b().m3439c()) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3044a, "Start HeartBeat.");
                    }
                    HeartBeat.m3575c();
                } else if (C0921g.f3116a) {
                    C0921g.m3637a(f3044a, "HeartBeat will not be started hence push service hadn't been started.");
                }
                if (this.f3048e != null) {
                    this.f3048e.mo3531a();
                    return;
                }
                return;
            }
            if (C0921g.f3119d) {
                C0921g.m3642d(f3044a, String.format("Init reply result code is error. ErrorCode: %d.", Integer.valueOf(iM341f)));
            }
            m3498g();
            m3495a(-104);
            if (iM341f == 4002 || iM341f == 4006) {
                try {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3044a, "Disconnect connection.");
                    }
                    this.f3047d.mo3457b();
                } catch (C0872e e) {
                }
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3044a, "Execute reprovisioning.");
                }
                C0904h.m3547b();
                C0879l.m3463a().m3471e();
                if (this.f3048e != null) {
                    this.f3048e.mo3532a(-104);
                    return;
                }
                return;
            }
            if (iM341f == 2002) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3044a, "Server error: internal server error.");
                }
                if (C0882a.m3483b() == EnumC0884c.Primary) {
                    try {
                        if (C0921g.f3116a) {
                            C0921g.m3637a(f3044a, "Disconnect connection.");
                        }
                        this.f3047d.mo3457b();
                    } catch (C0872e e2) {
                    }
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3044a, "Retry initialize using secondary push server.");
                    }
                    C0882a.m3480a();
                    C0879l.m3463a().m3471e();
                    if (this.f3048e != null) {
                        this.f3048e.mo3532a(-104);
                        return;
                    }
                    return;
                }
                if (C0882a.m3483b() == EnumC0884c.Secondary) {
                    try {
                        if (C0921g.f3116a) {
                            C0921g.m3637a(f3044a, "Disconnect connection.");
                        }
                        this.f3047d.mo3457b();
                    } catch (C0872e e3) {
                    }
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3044a, "Execute re-provisioning.");
                    }
                    C0904h.m3547b();
                    C0879l.m3463a().m3471e();
                    if (this.f3048e != null) {
                        this.f3048e.mo3532a(-104);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iM341f == 2003) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3044a, "Server error: interrupted.");
                }
                try {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3044a, "Disconnect connection.");
                    }
                    this.f3047d.mo3457b();
                } catch (C0872e e4) {
                }
                C0879l.m3463a().m3471e();
                if (this.f3048e != null) {
                    this.f3048e.mo3532a(-104);
                    return;
                }
                return;
            }
            return;
        }
        m3498g();
        m3495a(-104);
        if (i == -1) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3044a, "Internal error code is timeout.");
            }
            try {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3044a, "Disconnect connection.");
                }
                this.f3047d.mo3457b();
            } catch (C0872e e5) {
            }
            C0879l.m3463a().m3471e();
        }
        if (this.f3048e != null) {
            this.f3048e.mo3532a(-104);
        }
    }

    /* renamed from: a */
    private void m3495a(int i) {
        C0879l.m3463a().m3466a(i);
    }

    /* renamed from: a */
    public static synchronized boolean m3496a() {
        if (f3045b && !PushClientApplication.m3437b().m3440d().m3460c()) {
            f3045b = false;
        }
        return f3045b;
    }

    /* renamed from: b */
    public static synchronized void m3497b() {
        f3045b = true;
    }

    /* renamed from: g */
    public static synchronized void m3498g() {
        f3045b = false;
    }
}
