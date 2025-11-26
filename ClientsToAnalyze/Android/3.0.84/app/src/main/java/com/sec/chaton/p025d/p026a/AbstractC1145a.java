package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.p066d.p067a.p068a.AbstractC3315a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AbstractHttpTask2.java */
/* renamed from: com.sec.chaton.d.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1145a extends AbstractC3315a<C1580h, C0267d> implements Comparable<AbstractC1145a> {

    /* renamed from: a */
    protected C1580h f4569a;

    /* renamed from: b */
    private int f4570b;

    /* renamed from: c */
    private Future<?> f4571c;

    /* renamed from: a */
    protected abstract void mo5488a(C0267d c0267d);

    /* renamed from: f */
    protected abstract String mo5496f();

    public AbstractC1145a(Handler handler, C1580h c1580h) {
        this(handler, c1580h, EnumC1172b.BACKGROUND);
    }

    public AbstractC1145a(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(c1580h);
        this.f4569a = null;
        this.f4569a = c1580h;
        this.f4570b = enumC1172b.m5515a();
        c1580h.m6700a(handler);
    }

    /* renamed from: a */
    public int m5484a() {
        return this.f4570b;
    }

    /* renamed from: a */
    public void m5490a(Future<?> future) {
        this.f4571c = future;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final C0267d m5491b() {
        try {
            return (C0267d) this.f4571c.get();
        } catch (ExecutionException e) {
            return (C0267d) m11675k();
        }
    }

    /* renamed from: c */
    public final void m5493c() {
        m11680p();
        this.f4571c.cancel(true);
    }

    /* renamed from: d */
    public final boolean m5494d() {
        return m11677m() || this.f4571c.isCancelled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    /* renamed from: e */
    public C0267d m5495e() {
        try {
            return (C0267d) call();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, this.f11982d);
            }
            C0267d c0267d = (C0267d) m11675k();
            c0267d.m1350a((Throwable) e);
            return c0267d;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC1145a abstractC1145a) {
        long jM5484a = this.f4570b - abstractC1145a.m5484a();
        if (jM5484a < 0) {
            return -1;
        }
        if (jM5484a == 0) {
            return 0;
        }
        return 1;
    }

    @Override // com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0267d mo5487a(C1580h c1580h) {
        return new C0267d(c1580h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String mo5498h() {
        EnumC3219cg enumC3219cgM6698a = this.f4569a.m6698a();
        String strM11283b = C3216cd.m11283b(enumC3219cgM6698a);
        if (enumC3219cgM6698a.m11314a() && TextUtils.isEmpty(strM11283b)) {
            if (C3250y.f11735c) {
                C3250y.m11453c("Because server address is null, execute provisioning.", this.f11982d);
            }
            new C1334l(null).m5777b().m5495e();
        }
        return mo5496f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    @Override // com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo5489a(com.sec.chaton.p016a.p017a.C0267d r7) {
        /*
            r6 = this;
            r5 = 10008(0x2718, float:1.4024E-41)
            r4 = 10007(0x2717, float:1.4023E-41)
            boolean r0 = r7.m11704n()
            if (r0 != 0) goto L5d
            java.lang.Throwable r0 = r7.m1359j()
            boolean r0 = r0 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L5d
            com.sec.common.d.a.c r0 = r6.m11674j()
            com.sec.chaton.j.h r0 = (com.sec.chaton.p037j.C1580h) r0
            com.sec.chaton.util.cg r2 = r0.m6698a()
            boolean r1 = r2.m11314a()
            boolean r2 = r2.m11315b()
            if (r2 == 0) goto La2
            com.sec.chaton.util.cg r2 = r0.m6698a()
            com.sec.chaton.util.cf r2 = com.sec.chaton.util.C3216cd.m11276a(r2)
            com.sec.chaton.util.cf r3 = com.sec.chaton.util.EnumC3218cf.PRIMARY
            if (r2 != r3) goto L99
            boolean r1 = com.sec.chaton.util.C3250y.f11736d
            if (r1 == 0) goto L3d
            java.lang.String r1 = "For task is stopped by timeout, change server type to secondary."
            java.lang.String r2 = r6.f11982d
            com.sec.chaton.util.C3250y.m11455d(r1, r2)
        L3d:
            com.sec.chaton.util.cg r0 = r0.m6698a()
            com.sec.chaton.util.cf r1 = com.sec.chaton.util.EnumC3218cf.SECONDARY
            com.sec.chaton.util.C3216cd.m11279a(r0, r1)
            r0 = 0
        L47:
            if (r0 == 0) goto L5d
            boolean r0 = com.sec.chaton.util.C3250y.f11736d
            if (r0 == 0) goto L54
            java.lang.String r0 = "Re-execute GLD task."
            java.lang.String r1 = r6.f11982d
            com.sec.chaton.util.C3250y.m11455d(r0, r1)
        L54:
            com.sec.chaton.d.l r0 = new com.sec.chaton.d.l
            r1 = 0
            r0.<init>(r1)
            r0.m5775a()
        L5d:
            int r0 = r7.m1358i()
            r1 = 400(0x190, float:5.6E-43)
            if (r0 != r1) goto Lc9
            int r0 = r7.m1355f()
            if (r0 == r4) goto L81
            int r0 = r7.m1355f()
            r1 = 10003(0x2713, float:1.4017E-41)
            if (r0 == r1) goto L81
            int r0 = r7.m1355f()
            r1 = 10004(0x2714, float:1.4019E-41)
            if (r0 == r1) goto L81
            int r0 = r7.m1355f()
            if (r0 != r5) goto Lc9
        L81:
            com.sec.chaton.j.w r0 = com.sec.chaton.p037j.C1595w.m6742a()     // Catch: java.lang.InterruptedException -> La4
            r0.m6748e()     // Catch: java.lang.InterruptedException -> La4
            boolean r0 = com.sec.chaton.ExitAppDialogActivity.m1139a()
            if (r0 != 0) goto L98
            int r0 = r7.m1355f()
            if (r0 != r4) goto Lba
            r0 = 2
            com.sec.chaton.ExitAppDialogActivity.m1138a(r0)
        L98:
            return
        L99:
            com.sec.chaton.util.cg r0 = r0.m6698a()
            com.sec.chaton.util.cf r2 = com.sec.chaton.util.EnumC3218cf.PRIMARY
            com.sec.chaton.util.C3216cd.m11279a(r0, r2)
        La2:
            r0 = r1
            goto L47
        La4:
            r0 = move-exception
            boolean r1 = com.sec.chaton.util.C3250y.f11736d
            if (r1 == 0) goto L98
            java.lang.String r1 = "QueueManager.resetAllQueue is interrpted."
            java.lang.String r2 = r6.f11982d
            com.sec.chaton.util.C3250y.m11455d(r1, r2)
            java.lang.String r0 = com.sec.chaton.util.C3250y.m11436a(r0)
            java.lang.String r1 = r6.f11982d
            com.sec.chaton.util.C3250y.m11455d(r0, r1)
            goto L98
        Lba:
            int r0 = r7.m1355f()
            if (r0 != r5) goto Lc5
            r0 = 4
            com.sec.chaton.ExitAppDialogActivity.m1138a(r0)
            goto L98
        Lc5:
            com.sec.chaton.ExitAppDialogActivity.m1141b()
            goto L98
        Lc9:
            r6.mo5488a(r7)
            goto L98
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.AbstractC1145a.mo5489a(com.sec.chaton.a.a.d):void");
    }
}
