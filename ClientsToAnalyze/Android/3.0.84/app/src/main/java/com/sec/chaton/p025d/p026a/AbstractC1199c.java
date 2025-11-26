package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1548ag;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC1199c {

    /* renamed from: a */
    protected static int f4697a = 2;

    /* renamed from: b */
    protected Handler f4698b;

    /* renamed from: c */
    protected C1544ac f4699c;

    /* renamed from: d */
    protected int f4700d;

    /* renamed from: e */
    protected int f4701e;

    /* renamed from: f */
    protected long f4702f;

    /* renamed from: g */
    protected C1337o f4703g;

    /* renamed from: h */
    private C1548ag f4704h;

    /* renamed from: i */
    private HandlerC1232df f4705i;

    /* renamed from: a */
    protected abstract void mo5502a(int i, Object obj, Object obj2);

    /* renamed from: b */
    protected abstract C1548ag mo5504b();

    public AbstractC1199c(Handler handler) {
        this.f4705i = (HandlerC1232df) C1231de.m5555a().m5556b();
        this.f4698b = handler;
        this.f4700d = 0;
        this.f4701e = f4697a;
        this.f4703g = null;
    }

    public AbstractC1199c(Handler handler, int i) {
        this.f4705i = (HandlerC1232df) C1231de.m5555a().m5556b();
        this.f4698b = handler;
        this.f4700d = 0;
        this.f4701e = i;
        this.f4703g = null;
    }

    /* renamed from: a */
    public boolean mo5503a() {
        return this.f4700d < this.f4701e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c A[PHI: r0
  0x008c: PHI (r0v18 com.sec.chaton.j.ag) = 
  (r0v30 com.sec.chaton.j.ag)
  (r0v31 com.sec.chaton.j.ag)
  (r0v32 com.sec.chaton.j.ag)
  (r0v33 com.sec.chaton.j.ag)
  (r0v34 com.sec.chaton.j.ag)
 binds: [B:30:0x007d, B:24:0x0068, B:12:0x003c, B:18:0x0052, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.sec.chaton.j.ac] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.chaton.d.a.c, java.lang.Object] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m5539a(com.sec.chaton.p025d.p026a.AbstractC1199c r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.AbstractC1199c.m5539a(com.sec.chaton.d.a.c):void");
    }

    /* renamed from: a */
    public void m5540a(C1544ac c1544ac) {
        Message message = new Message();
        message.obj = this;
        this.f4699c = c1544ac;
        this.f4705i.sendMessage(message);
    }
}
