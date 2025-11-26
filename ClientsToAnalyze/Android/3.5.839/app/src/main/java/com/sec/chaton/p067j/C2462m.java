package com.sec.chaton.p067j;

import android.os.Handler;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.p129b.AbstractC4984a;
import com.sec.common.p126d.p127a.p129b.C4986c;
import com.sec.common.util.C5052r;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.m */
/* loaded from: classes.dex */
class C2462m<T extends C4986c> extends FutureTask<T> implements Comparable<C2462m<T>> {

    /* renamed from: a */
    private AbstractC4984a<?, T> f8835a;

    /* renamed from: b */
    private EnumC2463n f8836b;

    /* renamed from: c */
    private int f8837c;

    /* renamed from: d */
    private WeakReference<Handler> f8838d;

    public C2462m(AbstractC4984a<?, T> abstractC4984a, EnumC2463n enumC2463n, int i, Handler handler) {
        super(abstractC4984a);
        this.f8835a = abstractC4984a;
        this.f8836b = enumC2463n;
        this.f8837c = i;
        this.f8838d = new WeakReference<>(handler);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        T tI;
        Handler handler = this.f8838d.get();
        try {
            tI = get();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Task is interrupted.", C2461l.f8831a);
                C4904y.m18635a(e, C2461l.f8831a);
                return;
            }
            return;
        } catch (CancellationException e2) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Task is cancelled.", C2461l.f8831a);
                C4904y.m18635a(e2, C2461l.f8831a);
                return;
            }
            return;
        } catch (ExecutionException e3) {
            if (C4904y.f17875e) {
                C4904y.m18634a(C5052r.m19199a("Task is crashed. Message: ", e3.getMessage(), "\nEntry: ", null), C2461l.f8831a);
                C4904y.m18635a(e3.getCause(), C2461l.f8831a);
            }
            tI = this.f8835a.m18919i();
        }
        if (handler != null && tI != null) {
            handler.obtainMessage(this.f8837c, tI).sendToTarget();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2462m<T> c2462m) {
        long jM10668a = this.f8836b.m10668a() - c2462m.f8836b.m10668a();
        if (jM10668a < 0) {
            return -1;
        }
        if (jM10668a == 0) {
            return 0;
        }
        return 1;
    }
}
