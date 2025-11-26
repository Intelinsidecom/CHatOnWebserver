package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Looper;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.bf */
/* loaded from: classes.dex */
class HandlerC1320bf extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1318bd f4991a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1320bf(C1318bd c1318bd, Looper looper) {
        super(looper);
        this.f4991a = c1318bd;
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
            com.sec.chaton.d.bd r0 = r6.f4991a
            java.util.ArrayList r0 = com.sec.chaton.p025d.C1318bd.m5674b(r0)
            com.sec.chaton.d.bd r1 = r6.f4991a
            int r1 = com.sec.chaton.p025d.C1318bd.m5673a(r1)
            java.lang.Object r0 = r0.get(r1)
            com.sec.chaton.d.bg r0 = (com.sec.chaton.p025d.C1321bg) r0
            int[] r1 = com.sec.chaton.p025d.C1319be.f4990a
            com.sec.chaton.d.bh r3 = r0.m5686a()
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
            com.sec.chaton.d.bd r1 = r6.f4991a
            int r1 = com.sec.chaton.p025d.C1318bd.m5673a(r1)
            int r1 = r1 + 1
            com.sec.chaton.d.bd r2 = r6.f4991a
            java.util.ArrayList r2 = com.sec.chaton.p025d.C1318bd.m5674b(r2)
            int r2 = r2.size()
            if (r1 != r2) goto L84
        L39:
            com.sec.chaton.d.bd r1 = r6.f4991a
            android.os.Handler r1 = com.sec.chaton.p025d.C1318bd.m5675c(r1)
            if (r1 != 0) goto L5f
        L41:
            return
        L42:
            java.lang.Object r1 = r7.obj
            com.sec.chaton.a.a.d r1 = (com.sec.chaton.p016a.p017a.C0267d) r1
            com.sec.chaton.j.o r3 = r1.m1351b()
            com.sec.chaton.j.o r4 = com.sec.chaton.p037j.EnumC1587o.SUCCESS
            if (r3 == r4) goto L56
            com.sec.chaton.j.o r1 = r1.m1351b()
            com.sec.chaton.j.o r3 = com.sec.chaton.p037j.EnumC1587o.NO_CONTENT
            if (r1 != r3) goto L22
        L56:
            r1 = 1
            goto L23
        L58:
            java.lang.Object r1 = r7.obj
            com.sec.chaton.a.a.i r1 = (com.sec.chaton.p016a.p017a.C0272i) r1
            boolean r1 = r1.f858a
            goto L23
        L5f:
            android.os.Message r1 = android.os.Message.obtain()
            int r2 = r7.what
            r1.what = r2
            com.sec.chaton.d.bi r2 = new com.sec.chaton.d.bi
            com.sec.chaton.d.bd r3 = r6.f4991a
            long r3 = com.sec.chaton.p025d.C1318bd.m5676d(r3)
            com.sec.chaton.d.bh r0 = r0.m5686a()
            java.lang.Object r5 = r7.obj
            r2.<init>(r3, r0, r5)
            r1.obj = r2
            com.sec.chaton.d.bd r0 = r6.f4991a
            android.os.Handler r0 = com.sec.chaton.p025d.C1318bd.m5675c(r0)
            r0.sendMessage(r1)
            goto L41
        L84:
            com.sec.chaton.d.bd r0 = r6.f4991a
            com.sec.chaton.p025d.C1318bd.m5677e(r0)
            com.sec.chaton.d.bd r0 = r6.f4991a
            r0.m5683d()
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.HandlerC1320bf.handleMessage(android.os.Message):void");
    }
}
