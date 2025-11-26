package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: AbstractChatONHttpTextTask.java */
/* renamed from: com.sec.chaton.d.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1900a extends AbstractC1924ax<C2454e, C0778b> {

    /* renamed from: a */
    protected C2454e f7119a;

    /* renamed from: a */
    protected abstract void mo9084a(C0778b c0778b);

    /* renamed from: c */
    protected abstract String mo9086c();

    public AbstractC1900a(C2454e c2454e) {
        super(c2454e);
        this.f7119a = null;
        this.f7119a = c2454e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    /* renamed from: a */
    public C0778b m9082a() {
        try {
            return call();
        } catch (Error e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, this.f18194f);
            }
            throw e;
        } catch (Exception e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, this.f18194f);
            }
            return (C0778b) m18919i();
        }
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0778b mo6146a(C2454e c2454e) {
        return new C0778b(c2454e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String mo6150b() {
        EnumC4868cf enumC4868cfM10628a = this.f7119a.m10628a();
        String strM18450b = C4865cc.m18450b(enumC4868cfM10628a);
        if (enumC4868cfM10628a.m18486a() && TextUtils.isEmpty(strM18450b)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Because server address is null, execute provisioning.", this.f18194f);
            }
            new C2132m(null).m9555b().call();
        }
        return mo9086c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo6149a(com.sec.chaton.p046a.p047a.C0778b r9) {
        /*
            r8 = this;
            r7 = 10012(0x271c, float:1.403E-41)
            r6 = 10008(0x2718, float:1.4024E-41)
            r5 = 10007(0x2717, float:1.4023E-41)
            r1 = 0
            boolean r0 = r9.m18954n()
            if (r0 != 0) goto L62
            java.lang.Throwable r0 = r9.m3134j()
            boolean r0 = r0 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L62
            com.sec.common.d.a.c r0 = r8.m18918h()
            com.sec.chaton.j.e r0 = (com.sec.chaton.p067j.C2454e) r0
            com.sec.chaton.util.cf r3 = r0.m10628a()
            boolean r2 = r3.m18486a()
            boolean r3 = r3.m18487b()
            if (r3 == 0) goto La9
            com.sec.chaton.util.cf r3 = r0.m10628a()
            com.sec.chaton.util.ce r3 = com.sec.chaton.util.C4865cc.m18443a(r3)
            com.sec.chaton.util.ce r4 = com.sec.chaton.util.EnumC4867ce.PRIMARY
            if (r3 != r4) goto La0
            boolean r2 = com.sec.chaton.util.C4904y.f17874d
            if (r2 == 0) goto L41
            java.lang.String r2 = "For task is stopped by timeout, change server type to secondary."
            java.lang.String r3 = r8.f18194f
            com.sec.chaton.util.C4904y.m18645d(r2, r3)
        L41:
            com.sec.chaton.util.cf r0 = r0.m10628a()
            com.sec.chaton.util.ce r2 = com.sec.chaton.util.EnumC4867ce.SECONDARY
            com.sec.chaton.util.C4865cc.m18446a(r0, r2)
            r0 = r1
        L4b:
            if (r0 == 0) goto L62
            boolean r0 = com.sec.chaton.util.C4904y.f17874d
            if (r0 == 0) goto L59
            java.lang.String r0 = "Re-execute GLD task."
            java.lang.String r2 = r8.f18194f
            com.sec.chaton.util.C4904y.m18645d(r0, r2)
        L59:
            com.sec.chaton.d.m r0 = new com.sec.chaton.d.m
            r2 = 0
            r0.<init>(r2)
            r0.m9552a()
        L62:
            int r0 = r9.m3114i()
            r2 = 400(0x190, float:5.6E-43)
            if (r0 != r2) goto Lbb
            int r0 = r9.m3111f()
            if (r0 == r5) goto L8c
            int r0 = r9.m3111f()
            r2 = 10003(0x2713, float:1.4017E-41)
            if (r0 == r2) goto L8c
            int r0 = r9.m3111f()
            r2 = 10004(0x2714, float:1.4019E-41)
            if (r0 == r2) goto L8c
            int r0 = r9.m3111f()
            if (r0 == r6) goto L8c
            int r0 = r9.m3111f()
            if (r0 != r7) goto Lbb
        L8c:
            int r0 = r9.m3111f()
            if (r0 != r5) goto Lab
            r0 = 2
        L93:
            com.sec.chaton.bg r1 = new com.sec.chaton.bg
            r1.<init>(r0)
            com.sec.common.e.a r0 = com.sec.chaton.C0991aa.m6037a()
            r0.m18962d(r1)
        L9f:
            return
        La0:
            com.sec.chaton.util.cf r0 = r0.m10628a()
            com.sec.chaton.util.ce r3 = com.sec.chaton.util.EnumC4867ce.PRIMARY
            com.sec.chaton.util.C4865cc.m18446a(r0, r3)
        La9:
            r0 = r2
            goto L4b
        Lab:
            int r0 = r9.m3111f()
            if (r0 != r6) goto Lb3
            r0 = 4
            goto L93
        Lb3:
            int r0 = r9.m3111f()
            if (r0 != r7) goto Lbf
            r0 = 5
            goto L93
        Lbb:
            r8.mo9084a(r9)
            goto L9f
        Lbf:
            r0 = r1
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.AbstractC1900a.mo6149a(com.sec.chaton.a.a.b):void");
    }
}
