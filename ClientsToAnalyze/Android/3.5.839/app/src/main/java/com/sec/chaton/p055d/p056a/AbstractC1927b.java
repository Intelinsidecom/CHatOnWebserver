package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2426ao;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1927b {

    /* renamed from: a */
    protected static int f7185a = 2;

    /* renamed from: b */
    protected Handler f7186b;

    /* renamed from: c */
    protected C2422ak f7187c;

    /* renamed from: d */
    protected int f7188d;

    /* renamed from: e */
    protected int f7189e;

    /* renamed from: f */
    protected long f7190f;

    /* renamed from: g */
    protected C2142w f7191g;

    /* renamed from: h */
    private C2426ao f7192h;

    /* renamed from: i */
    private HandlerC2003dv f7193i;

    /* renamed from: a */
    protected abstract void mo9092a(int i, Object obj, Object obj2);

    /* renamed from: b */
    protected abstract C2426ao mo9093b();

    public AbstractC1927b(Handler handler) {
        this.f7193i = (HandlerC2003dv) C2002du.m9149a().m9150b();
        this.f7186b = handler;
        this.f7188d = 0;
        this.f7189e = f7185a;
        this.f7191g = null;
    }

    public AbstractC1927b(Handler handler, int i) {
        this.f7193i = (HandlerC2003dv) C2002du.m9149a().m9150b();
        this.f7186b = handler;
        this.f7188d = 0;
        this.f7189e = i;
        this.f7191g = null;
    }

    /* renamed from: a */
    public boolean mo9104a() {
        return this.f7188d < this.f7189e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0139 A[PHI: r0
  0x0139: PHI (r0v28 com.sec.chaton.j.ao) = 
  (r0v16 com.sec.chaton.j.ao)
  (r0v19 com.sec.chaton.j.ao)
  (r0v22 com.sec.chaton.j.ao)
  (r0v25 com.sec.chaton.j.ao)
  (r0v38 com.sec.chaton.j.ao)
 binds: [B:30:0x00f0, B:24:0x00be, B:12:0x005a, B:18:0x008c, B:5:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v13, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.sec.chaton.j.ak] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.chaton.d.a.b, java.lang.Object] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m9102a(com.sec.chaton.p055d.p056a.AbstractC1927b r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.AbstractC1927b.m9102a(com.sec.chaton.d.a.b):void");
    }

    /* renamed from: a */
    public void m9103a(C2422ak c2422ak) {
        Message message = new Message();
        message.obj = this;
        this.f7187c = c2422ak;
        this.f7193i.sendMessage(message);
    }
}
