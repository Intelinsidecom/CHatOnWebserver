package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.C0881a;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0890b;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0919e;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0074ah;
import com.sec.p004a.p005a.p006a.C0090i;
import com.sec.p004a.p005a.p006a.C0093l;

/* compiled from: DeregistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.d */
/* loaded from: classes.dex */
public class C0885d extends AbstractC0894f implements InterfaceC0890b {

    /* renamed from: a */
    private static final String f3031a = C0885d.class.getSimpleName();

    /* renamed from: b */
    private int f3032b;

    /* renamed from: c */
    private String f3033c;

    /* renamed from: d */
    private C0866d f3034d;

    /* renamed from: e */
    private InterfaceC0898j f3035e;

    public C0885d(Context context, String str) {
        super(context, 2L);
        this.f3033c = str;
        this.f3034d = PushClientApplication.m3437b().m3440d();
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: c */
    public Class mo3487c() {
        return C0090i.class;
    }

    /* renamed from: a */
    public void m3489a(InterfaceC0898j interfaceC0898j) {
        this.f3035e = interfaceC0898j;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3031a, "DeregistrationMessageTask.onRequest().");
        }
        String strM3560e = C0904h.m3560e((String) null);
        if (strM3560e == null || !strM3560e.equals(this.f3033c)) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3031a, String.format("The application(id:%s) had been deregistered. callback success to application without networking.", this.f3033c));
            }
            if (this.f3035e == null) {
                return null;
            }
            this.f3035e.mo3531a();
            return null;
        }
        if (!C0888g.m3496a()) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3031a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0888g(m3518e()));
                C0896h.m3520a().m3527a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C0921g.f3119d) {
                    return null;
                }
                C0921g.m3638a(f3031a, e.getMessage(), e);
                return null;
            }
        }
        this.f3032b = C0919e.m3620a();
        C0093l c0093lNewBuilder = C0074ah.newBuilder();
        c0093lNewBuilder.m415a(this.f3032b);
        c0093lNewBuilder.m418a(C0904h.m3546b((String) null));
        c0093lNewBuilder.m420b(C0904h.m3562f((String) null));
        c0093lNewBuilder.m422c("");
        return new C0881a().m3478a(this.f3034d).m3477a(c0093lNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: a */
    public void mo3486a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3031a, String.format("DeregistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3031a, "Response message is null.");
                    return;
                }
                return;
            }
            C0090i c0090i = (C0090i) generatedMessageLite;
            int iM387f = c0090i.m387f();
            if (this.f3032b != c0090i.m385d()) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3031a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f3032b), Integer.valueOf(c0090i.m385d())));
                    return;
                }
                return;
            }
            if (iM387f == 1000) {
                SharedPreferences.Editor editorM3538a = C0904h.m3538a();
                C0904h.m3565g(editorM3538a);
                C0904h.m3567h(editorM3538a);
                editorM3538a.commit();
                try {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3031a, "Close connection.");
                    }
                    this.f3034d.mo3457b();
                } catch (C0872e e) {
                }
                HeartBeat.m3576d();
                m3518e().stopService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f3035e != null) {
                    this.f3035e.mo3531a();
                    return;
                }
                return;
            }
            if (C0921g.f3119d) {
                C0921g.m3642d(f3031a, String.format("Deregistration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM387f)));
            }
            if (iM387f == 4002 || iM387f == 4009) {
                if (C0921g.f3119d) {
                    if (iM387f == 4002) {
                        if (C0921g.f3119d) {
                            C0921g.m3642d(f3031a, "Server error: empty device token.");
                        }
                    } else if (iM387f == 4009 && C0921g.f3119d) {
                        C0921g.m3642d(f3031a, "Server error: wrong device token.");
                    }
                }
                try {
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3031a, "Close connection.");
                    }
                    this.f3034d.mo3457b();
                } catch (C0872e e2) {
                }
                C0904h.m3547b();
                C0879l.m3463a().m3471e();
                if (this.f3035e != null) {
                    this.f3035e.mo3532a(iM387f);
                    return;
                }
                return;
            }
            if (iM387f == 4004) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3031a, "Server error: empty application id.");
                    C0921g.m3642d(f3031a, "Do not anything.");
                }
                if (this.f3035e != null) {
                    this.f3035e.mo3532a(iM387f);
                    return;
                }
                return;
            }
            if (iM387f == 4001) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3031a, "Server error: invalid state.");
                    C0921g.m3642d(f3031a, "Close connection.");
                }
                try {
                    this.f3034d.mo3457b();
                } catch (C0872e e3) {
                }
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3031a, "Execute initialization.");
                }
                C0879l.m3463a().m3471e();
                if (this.f3035e != null) {
                    this.f3035e.mo3532a(iM387f);
                    return;
                }
                return;
            }
            if (iM387f == 4008) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3031a, "Server error: invalid state.");
                    C0921g.m3642d(f3031a, "Close connection.");
                }
                if (this.f3035e != null) {
                    this.f3035e.mo3532a(iM387f);
                    return;
                }
                return;
            }
            if (this.f3035e != null) {
                this.f3035e.mo3532a(iM387f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3031a, "Internal error code is timeout.");
            }
            try {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3031a, "Disconnect connection.");
                }
                this.f3034d.mo3457b();
            } catch (C0872e e4) {
            }
            C0879l.m3463a().m3471e();
        }
        if (this.f3035e != null) {
            this.f3035e.mo3532a(i);
        }
    }
}
