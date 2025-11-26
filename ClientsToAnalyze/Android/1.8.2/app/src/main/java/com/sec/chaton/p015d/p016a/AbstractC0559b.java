package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0805o;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.util.C1771c;
import com.sec.chaton.util.C1786r;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC0559b {

    /* renamed from: a */
    protected static int f2235a = 2;

    /* renamed from: b */
    protected Handler f2236b;

    /* renamed from: c */
    protected C0816z f2237c;

    /* renamed from: d */
    protected int f2238d;

    /* renamed from: f */
    protected long f2240f;

    /* renamed from: h */
    private C0770ab f2242h;

    /* renamed from: i */
    private HandlerC0570bk f2243i = (HandlerC0570bk) C0569bj.m2760a().m2761b();

    /* renamed from: e */
    protected int f2239e = 0;

    /* renamed from: g */
    protected C0639k f2241g = null;

    /* renamed from: a */
    protected abstract void mo2747a(int i, Object obj, Object obj2);

    /* renamed from: c */
    protected abstract C0770ab mo2748c();

    public AbstractC0559b(Handler handler) {
        this.f2236b = handler;
    }

    public AbstractC0559b(Handler handler, int i) {
        this.f2236b = handler;
        this.f2238d = i;
    }

    /* renamed from: a */
    public boolean m2758a() {
        return this.f2239e < f2235a;
    }

    /* renamed from: b */
    public boolean m2759b() {
        return this.f2239e < this.f2238d;
    }

    /* renamed from: a */
    protected void m2756a(AbstractC0559b abstractC0559b) {
        this.f2239e++;
        C1786r.m6061b("onPreExecute - start", getClass().getSimpleName());
        C0770ab c0770abMo2748c = mo2748c();
        C1786r.m6061b("onPreExecute - end", getClass().getSimpleName());
        if (this.f2237c.m3457f() == null) {
            String strM6029a = GlobalApplication.m3264e().m6029a();
            if (!TextUtils.isEmpty(strM6029a)) {
                byte[] bArrM6013b = C1771c.m6013b(strM6029a);
                byte[] bArrM6014c = C1771c.m6014c(strM6029a);
                if (bArrM6013b != null && bArrM6014c != null) {
                    try {
                        this.f2237c.m3453a(bArrM6013b, bArrM6014c);
                    } catch (Exception e) {
                        C1786r.m6054a(e.getMessage(), "AesCipher");
                    }
                }
            }
        }
        if (this.f2237c.m3457f() == null) {
            mo2747a(11, null, null);
            return;
        }
        if (c0770abMo2748c == null) {
            mo2747a(3, null, null);
            return;
        }
        this.f2242h = c0770abMo2748c;
        C0586c c0586c = new C0586c(this, this.f2242h, this.f2237c);
        this.f2242h.m3286a(new C0805o(this.f2243i, c0586c));
        c0586c.m2780a();
    }

    /* renamed from: a */
    public void m2757a(C0816z c0816z) {
        Message message = new Message();
        message.obj = this;
        this.f2237c = c0816z;
        this.f2243i.sendMessage(message);
    }
}
