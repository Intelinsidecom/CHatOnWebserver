package com.sec.chaton.p037j;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.m */
/* loaded from: classes.dex */
class C1585m extends C1586n<C0267d> {

    /* renamed from: a */
    final /* synthetic */ AbstractC1145a f5894a;

    /* renamed from: b */
    final /* synthetic */ C1584l f5895b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1585m(C1584l c1584l, AbstractC1145a abstractC1145a, AbstractC1145a abstractC1145a2) {
        super(abstractC1145a);
        this.f5895b = c1584l;
        this.f5894a = abstractC1145a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.FutureTask
    protected void done() {
        C0267d c0267d;
        Handler handlerM6705e = ((C1580h) this.f5894a.m11674j()).m6705e();
        int iM6704d = ((C1580h) this.f5894a.m11674j()).m6704d();
        try {
            c0267d = (C0267d) get();
        } catch (InterruptedException e) {
            if (C3250y.f11737e) {
                C3250y.m11442a("Task is interrupted.", C1584l.f5890a);
                C3250y.m11443a(e, C1584l.f5890a);
                return;
            }
            return;
        } catch (CancellationException e2) {
            if (C3250y.f11737e) {
                C3250y.m11442a("Task is cancelled.", C1584l.f5890a);
                C3250y.m11443a(e2, C1584l.f5890a);
                return;
            }
            return;
        } catch (ExecutionException e3) {
            c0267d = (C0267d) this.f5894a.m11675k();
            c0267d.m1350a(e3.getCause());
            if (C3250y.f11737e) {
                C3250y.m11442a(C3364o.m11849a("Task is crashed. Message: ", e3.getMessage(), "\nEntry: ", c0267d), C1584l.f5890a);
                C3250y.m11443a(e3.getCause(), C1584l.f5890a);
            }
        }
        if (handlerM6705e != null && c0267d != null) {
            handlerM6705e.obtainMessage(iM6704d, c0267d).sendToTarget();
        }
    }
}
