package com.sec.chaton.p067j;

import android.os.Handler;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.p129b.AbstractC4984a;
import com.sec.common.p126d.p127a.p129b.C4985b;
import com.sec.common.p126d.p127a.p129b.C4986c;
import com.sec.common.util.C5052r;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.l */
/* loaded from: classes.dex */
public class C2461l {

    /* renamed from: a */
    private static final String f8831a = C2461l.class.getSimpleName();

    /* renamed from: b */
    private String f8832b;

    /* renamed from: c */
    private ThreadPoolExecutor f8833c;

    /* renamed from: d */
    private BlockingQueue<Runnable> f8834d;

    public C2461l(String str) {
        this(str, 1, 1);
    }

    public C2461l(String str, int i, int i2) {
        this.f8833c = null;
        this.f8834d = null;
        this.f8832b = str;
        this.f8834d = new PriorityBlockingQueue();
        this.f8833c = new ThreadPoolExecutor(i, i2, 0L, TimeUnit.MILLISECONDS, this.f8834d);
        this.f8833c.prestartAllCoreThreads();
    }

    /* renamed from: a */
    public <ReqType extends C4985b, ResType extends C4986c> Future<ResType> m10661a(AbstractC4984a<ReqType, ResType> abstractC4984a) {
        return m10663a(abstractC4984a, EnumC2463n.BACKGROUND);
    }

    /* renamed from: a */
    public <ReqType extends C4985b, ResType extends C4986c> Future<ResType> m10663a(AbstractC4984a<ReqType, ResType> abstractC4984a, EnumC2463n enumC2463n) {
        return m10664a(abstractC4984a, enumC2463n, -1, null);
    }

    /* renamed from: a */
    public <ReqType extends C4985b, ResType extends C4986c> Future<ResType> m10662a(AbstractC4984a<ReqType, ResType> abstractC4984a, int i, Handler handler) {
        return m10664a(abstractC4984a, EnumC2463n.BACKGROUND, i, handler);
    }

    /* renamed from: a */
    public <ReqType extends C4985b, ResType extends C4986c> Future<ResType> m10664a(AbstractC4984a<ReqType, ResType> abstractC4984a, EnumC2463n enumC2463n, int i, Handler handler) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Task is reserved. Task: ", abstractC4984a, ", Queue(name: ", this.f8832b, ", size: ", Integer.valueOf(this.f8834d.size()), ")"), f8831a);
        }
        C2462m c2462m = new C2462m(abstractC4984a, enumC2463n, i, handler);
        this.f8833c.execute(c2462m);
        return c2462m;
    }

    /* renamed from: a */
    public void m10665a() throws InterruptedException {
        m10666a(60000);
    }

    /* renamed from: a */
    public void m10666a(int i) throws InterruptedException {
        try {
            this.f8833c.shutdown();
            this.f8833c.shutdownNow();
            this.f8833c.awaitTermination(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }
}
