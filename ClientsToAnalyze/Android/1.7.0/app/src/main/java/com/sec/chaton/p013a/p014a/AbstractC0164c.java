package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0510q;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0164c {

    /* renamed from: a */
    protected static int f386a = 2;

    /* renamed from: b */
    protected Handler f387b;

    /* renamed from: c */
    protected C0505l f388c;

    /* renamed from: d */
    protected int f389d;

    /* renamed from: e */
    protected int f390e;

    /* renamed from: f */
    protected long f391f;

    /* renamed from: g */
    protected C0223v f392g;

    /* renamed from: h */
    private C0510q f393h;

    /* renamed from: i */
    private HandlerC0173l f394i;

    /* renamed from: a */
    protected abstract C0510q mo665a();

    /* renamed from: a */
    protected abstract void mo666a(int i, Object obj, Object obj2);

    public AbstractC0164c(Handler handler) {
        this.f394i = (HandlerC0173l) C0134aj.m678a().m679b();
        this.f387b = handler;
        this.f389d = 0;
        this.f390e = f386a;
        this.f392g = null;
    }

    public AbstractC0164c(Handler handler, int i) {
        this.f394i = (HandlerC0173l) C0134aj.m678a().m679b();
        this.f387b = handler;
        this.f389d = 0;
        this.f390e = i;
        this.f392g = null;
    }

    /* renamed from: b */
    public boolean m703b() {
        return this.f389d < this.f390e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c A[PHI: r0
  0x008c: PHI (r0v18 com.sec.chaton.c.q) = 
  (r0v30 com.sec.chaton.c.q)
  (r0v31 com.sec.chaton.c.q)
  (r0v32 com.sec.chaton.c.q)
  (r0v33 com.sec.chaton.c.q)
  (r0v34 com.sec.chaton.c.q)
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
    /* JADX WARN: Type inference failed for: r4v8, types: [com.sec.chaton.c.l] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.chaton.a.a.c, java.lang.Object] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m701a(com.sec.chaton.p013a.p014a.AbstractC0164c r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p013a.p014a.AbstractC0164c.m701a(com.sec.chaton.a.a.c):void");
    }

    /* renamed from: a */
    public void m702a(C0505l c0505l) {
        Message message = new Message();
        message.obj = this;
        this.f388c = c0505l;
        this.f394i.sendMessage(message);
    }
}
