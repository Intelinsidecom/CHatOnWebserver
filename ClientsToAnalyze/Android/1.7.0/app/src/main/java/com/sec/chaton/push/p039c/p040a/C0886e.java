package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
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
import com.sec.p004a.p005a.p006a.C0066a;
import com.sec.p004a.p005a.p006a.C0071ae;
import com.sec.p004a.p005a.p006a.C0089h;

/* compiled from: RegistrationMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.e */
/* loaded from: classes.dex */
public class C0886e extends AbstractC0894f implements InterfaceC0890b {

    /* renamed from: a */
    private static final String f3036a = AbstractC0894f.class.getSimpleName();

    /* renamed from: b */
    private int f3037b;

    /* renamed from: c */
    private String f3038c;

    /* renamed from: d */
    private C0866d f3039d;

    /* renamed from: e */
    private InterfaceC0898j f3040e;

    public C0886e(Context context, String str) {
        super(context, 2L);
        this.f3038c = str;
        this.f3039d = ((PushClientApplication) PushClientApplication.m3436a()).m3440d();
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: c */
    public Class mo3487c() {
        return C0089h.class;
    }

    /* renamed from: a */
    public void m3490a(InterfaceC0898j interfaceC0898j) {
        this.f3040e = interfaceC0898j;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3036a, "RegistrationMessageTask.onRequest().");
        }
        if (!C0888g.m3496a()) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3036a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0888g(m3518e()));
                C0896h.m3520a().m3527a(this);
                return null;
            } catch (InterruptedException e) {
                if (!C0921g.f3119d) {
                    return null;
                }
                C0921g.m3638a(f3036a, e.getMessage(), e);
                return null;
            }
        }
        this.f3037b = C0919e.m3620a();
        C0071ae c0071aeNewBuilder = C0066a.newBuilder();
        c0071aeNewBuilder.m172a(this.f3037b);
        c0071aeNewBuilder.m175a(C0904h.m3546b((String) null));
        c0071aeNewBuilder.m177b(this.f3038c);
        c0071aeNewBuilder.m179c("");
        return new C0881a().m3478a(this.f3039d).m3477a(c0071aeNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: a */
    public void mo3486a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3036a, String.format("RegistrationMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3036a, "Response message is null.");
                    return;
                }
                return;
            }
            C0089h c0089h = (C0089h) generatedMessageLite;
            int iM363f = c0089h.m363f();
            if (this.f3037b != c0089h.m361d()) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3036a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f3037b), Integer.valueOf(c0089h.m361d())));
                    return;
                }
                return;
            }
            if (iM363f == 1000) {
                SharedPreferences.Editor editorM3538a = C0904h.m3538a();
                C0904h.m3550b(editorM3538a, this.f3038c);
                C0904h.m3554c(editorM3538a, c0089h.m367j());
                editorM3538a.commit();
                m3518e().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                if (this.f3040e != null) {
                    this.f3040e.mo3531a();
                    return;
                }
                return;
            }
            if (C0921g.f3119d) {
                C0921g.m3642d(f3036a, String.format("Registration reply result code is error. ErrorCode: %d.", Integer.valueOf(iM363f)));
            }
            if (iM363f == 4002) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3036a, "Server error: empty device token.");
                    C0921g.m3642d(f3036a, "Close connection.");
                }
                try {
                    this.f3039d.mo3457b();
                } catch (C0872e e) {
                }
                C0904h.m3547b();
                C0879l.m3463a().m3471e();
                if (this.f3040e != null) {
                    this.f3040e.mo3532a(iM363f);
                    return;
                }
                return;
            }
            if (iM363f == 4003) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3036a, "Server error: empty application id.");
                    C0921g.m3642d(f3036a, "Do not anything.");
                }
                try {
                    this.f3039d.mo3457b();
                } catch (C0872e e2) {
                }
                C0879l.m3463a().m3471e();
                if (this.f3040e != null) {
                    this.f3040e.mo3532a(iM363f);
                    return;
                }
                return;
            }
            if (iM363f == 4001) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3036a, "Server error: empty device token.");
                    C0921g.m3642d(f3036a, "Close connection.");
                }
                try {
                    this.f3039d.mo3457b();
                } catch (C0872e e3) {
                }
                C0879l.m3463a().m3471e();
                if (this.f3040e != null) {
                    this.f3040e.mo3532a(iM363f);
                    return;
                }
                return;
            }
            if (iM363f == 4007) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3036a, "Server error: registration failed.");
                    C0921g.m3642d(f3036a, "Do not anything.");
                }
                if (this.f3040e != null) {
                    this.f3040e.mo3532a(iM363f);
                    return;
                }
                return;
            }
            if (this.f3040e != null) {
                this.f3040e.mo3532a(iM363f);
                return;
            }
            return;
        }
        if (i == -1) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3036a, "Internal error code is timeout.");
            }
            try {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3036a, "Disconnect connection.");
                }
                this.f3039d.mo3457b();
            } catch (C0872e e4) {
            }
            C0879l.m3463a().m3471e();
        }
        if (this.f3040e != null) {
            this.f3040e.mo3532a(i);
        }
    }
}
