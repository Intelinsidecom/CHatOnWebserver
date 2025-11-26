package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Looper;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.bv */
/* loaded from: classes.dex */
class HandlerC2116bv extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2114bt f7685a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2116bv(C2114bt c2114bt, Looper looper) {
        super(looper);
        this.f7685a = c2114bt;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0022  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r7) {
        /*
            r6 = this;
            r2 = 0
            com.sec.chaton.d.bt r0 = r6.f7685a
            java.util.ArrayList r0 = com.sec.chaton.p055d.C2114bt.m9448b(r0)
            com.sec.chaton.d.bt r1 = r6.f7685a
            int r1 = com.sec.chaton.p055d.C2114bt.m9447a(r1)
            java.lang.Object r0 = r0.get(r1)
            com.sec.chaton.d.bw r0 = (com.sec.chaton.p055d.C2117bw) r0
            int[] r1 = com.sec.chaton.p055d.C2115bu.f7684a
            com.sec.chaton.d.bx r3 = r0.m9460a()
            int r3 = r3.ordinal()
            r1 = r1[r3]
            switch(r1) {
                case 1: goto L42;
                case 2: goto L58;
                default: goto L22;
            }
        L22:
            r1 = r2
        L23:
            if (r1 == 0) goto L39
            com.sec.chaton.d.bt r1 = r6.f7685a
            int r1 = com.sec.chaton.p055d.C2114bt.m9447a(r1)
            int r1 = r1 + 1
            com.sec.chaton.d.bt r2 = r6.f7685a
            java.util.ArrayList r2 = com.sec.chaton.p055d.C2114bt.m9448b(r2)
            int r2 = r2.size()
            if (r1 != r2) goto L84
        L39:
            com.sec.chaton.d.bt r1 = r6.f7685a
            android.os.Handler r1 = com.sec.chaton.p055d.C2114bt.m9449c(r1)
            if (r1 != 0) goto L5f
        L41:
            return
        L42:
            java.lang.Object r1 = r7.obj
            com.sec.chaton.a.a.b r1 = (com.sec.chaton.p046a.p047a.C0778b) r1
            com.sec.chaton.j.o r3 = r1.m3107b()
            com.sec.chaton.j.o r4 = com.sec.chaton.p067j.EnumC2464o.SUCCESS
            if (r3 == r4) goto L56
            com.sec.chaton.j.o r1 = r1.m3107b()
            com.sec.chaton.j.o r3 = com.sec.chaton.p067j.EnumC2464o.NO_CONTENT
            if (r1 != r3) goto L22
        L56:
            r1 = 1
            goto L23
        L58:
            java.lang.Object r1 = r7.obj
            com.sec.chaton.a.a.l r1 = (com.sec.chaton.p046a.p047a.C0788l) r1
            boolean r1 = r1.f2172a
            goto L23
        L5f:
            android.os.Message r1 = android.os.Message.obtain()
            int r2 = r7.what
            r1.what = r2
            com.sec.chaton.d.by r2 = new com.sec.chaton.d.by
            com.sec.chaton.d.bt r3 = r6.f7685a
            long r3 = com.sec.chaton.p055d.C2114bt.m9450d(r3)
            com.sec.chaton.d.bx r0 = r0.m9460a()
            java.lang.Object r5 = r7.obj
            r2.<init>(r3, r0, r5)
            r1.obj = r2
            com.sec.chaton.d.bt r0 = r6.f7685a
            android.os.Handler r0 = com.sec.chaton.p055d.C2114bt.m9449c(r0)
            r0.sendMessage(r1)
            goto L41
        L84:
            com.sec.chaton.d.bt r0 = r6.f7685a
            com.sec.chaton.p055d.C2114bt.m9451e(r0)
            com.sec.chaton.d.bt r0 = r6.f7685a
            r0.m9457d()
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.HandlerC2116bv.handleMessage(android.os.Message):void");
    }
}
