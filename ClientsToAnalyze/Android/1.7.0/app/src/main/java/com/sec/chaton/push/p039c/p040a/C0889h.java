package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.C0881a;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0890b;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0919e;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0075ai;
import com.sec.p004a.p005a.p006a.C0094m;
import com.sec.p004a.p005a.p006a.C0104w;

/* compiled from: PingMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.h */
/* loaded from: classes.dex */
public class C0889h extends AbstractC0894f implements InterfaceC0890b {

    /* renamed from: a */
    private static final String f3049a = C0889h.class.getSimpleName();

    /* renamed from: b */
    private int f3050b;

    /* renamed from: c */
    private C0866d f3051c;

    /* renamed from: d */
    private InterfaceC0898j f3052d;

    public C0889h(Context context) {
        super(context, 2L);
        this.f3051c = PushClientApplication.m3437b().m3440d();
    }

    /* renamed from: a */
    public void m3499a(InterfaceC0898j interfaceC0898j) {
        this.f3052d = interfaceC0898j;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: c */
    public Class mo3487c() {
        return C0094m.class;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3049a, "PingMessageTask.onRequest().");
        }
        if (!C0888g.m3496a()) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3049a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0888g(m3518e()));
                C0896h.m3520a().m3527a(this);
            } catch (InterruptedException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(f3049a, e.getMessage(), e);
                }
            }
            return null;
        }
        this.f3050b = C0919e.m3620a();
        C0075ai c0075aiNewBuilder = C0104w.newBuilder();
        c0075aiNewBuilder.m241a(this.f3050b);
        c0075aiNewBuilder.m242a(System.currentTimeMillis());
        c0075aiNewBuilder.m246b(C0904h.m3551c(8));
        return new C0881a().m3478a(this.f3051c).m3477a(c0075aiNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: a */
    public void mo3486a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3049a, String.format("PingMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3049a, "Response message is null.");
                    return;
                }
                return;
            }
            C0094m c0094m = (C0094m) generatedMessageLite;
            if (this.f3050b != c0094m.m435d()) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3049a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f3050b), Integer.valueOf(c0094m.m435d())));
                    return;
                }
                return;
            } else {
                if (this.f3052d != null) {
                    this.f3052d.mo3531a();
                    return;
                }
                return;
            }
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3049a, "Close connection.");
        }
        try {
            this.f3051c.mo3457b();
        } catch (C0872e e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3049a, e.getMessage(), e);
            }
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3049a, "Execeute initialize.");
        }
        try {
            C0896h.m3520a().m3527a(new C0888g(PushClientApplication.m3436a()));
        } catch (InterruptedException e2) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3049a, e2.getMessage(), e2);
            }
        }
        if (this.f3052d != null) {
            this.f3052d.mo3532a(i);
        }
    }
}
