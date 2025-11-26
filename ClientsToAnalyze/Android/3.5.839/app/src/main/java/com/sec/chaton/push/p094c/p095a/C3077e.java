package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.C3087h;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.p094c.InterfaceC3083d;
import com.sec.chaton.push.util.C3112d;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;
import com.sec.p043a.p044a.p045a.C0734aa;
import com.sec.p043a.p044a.p045a.C0735ab;
import com.sec.p043a.p044a.p045a.C0772x;

/* compiled from: PingMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.e */
/* loaded from: classes.dex */
public class C3077e extends AbstractC3072a implements InterfaceC3083d {

    /* renamed from: a */
    private static final String f11370a = C3077e.class.getSimpleName();

    /* renamed from: b */
    private int f11371b;

    /* renamed from: c */
    private C3060d f11372c;

    /* renamed from: d */
    private InterfaceC3081b f11373d;

    public C3077e(Context context) {
        super(context, 2L);
        this.f11372c = PushClientApplication.m12499n().m12502p();
    }

    /* renamed from: a */
    public void m12550a(InterfaceC3081b interfaceC3081b) {
        this.f11373d = interfaceC3081b;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: n_ */
    public Class<? extends GeneratedMessageLite> mo12540n_() {
        return C0772x.class;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11370a, "PingMessageTask.onRequest().");
        }
        if (!C3074b.m12543d()) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11370a, "Initialize isn't completed. Execute initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3074b(m12535a()));
                C3088i.m12584a().m12591a(this);
            } catch (InterruptedException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(f11370a, e.getMessage(), e);
                }
            }
            return null;
        }
        this.f11371b = C3112d.m12683a();
        C0735ab c0735abNewBuilder = C0734aa.newBuilder();
        c0735abNewBuilder.m2334a(this.f11371b);
        c0735abNewBuilder.m2335a(System.currentTimeMillis());
        c0735abNewBuilder.m2339b(C3099k.m12639c(8));
        return new C3087h().m12582a(this.f11372c).m12581a(c0735abNewBuilder.build());
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: a */
    public void mo12538a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11370a, String.format("PingMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11370a, "Response message is null.");
                    return;
                }
                return;
            }
            C0772x c0772x = (C0772x) generatedMessageLite;
            if (this.f11371b != c0772x.m2800d()) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11370a, String.format("Request Async Id(%d) != Response Async Id(%d).", Integer.valueOf(this.f11371b), Integer.valueOf(c0772x.m2800d())));
                    return;
                }
                return;
            } else {
                if (this.f11373d != null) {
                    this.f11373d.mo12558a();
                    return;
                }
                return;
            }
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11370a, "Close connection.");
        }
        try {
            this.f11372c.mo12527b();
        } catch (C3044a e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11370a, e.getMessage(), e);
            }
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11370a, "Execeute initialize.");
        }
        try {
            C3088i.m12584a().m12591a(new C3074b(CommonApplication.m18732r()));
        } catch (InterruptedException e2) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11370a, e2.getMessage(), e2);
            }
        }
        if (this.f11373d != null) {
            this.f11373d.mo12559a(i);
        }
    }
}
