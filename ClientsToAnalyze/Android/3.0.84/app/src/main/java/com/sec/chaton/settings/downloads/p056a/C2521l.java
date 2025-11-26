package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.AbstractC3331a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: InstallAsyncWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.l */
/* loaded from: classes.dex */
public class C2521l<Params, DownloadResult> extends AbstractC3331a<Params, Integer, Boolean> {

    /* renamed from: b */
    private static final String f9640b = C2521l.class.getSimpleName();

    /* renamed from: g */
    private static HandlerC2524o f9641g = new HandlerC2524o();

    /* renamed from: h */
    private static final ExecutorService f9642h = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private List<Handler> f9643c;

    /* renamed from: d */
    private int f9644d;

    /* renamed from: e */
    private EnumC1399aq f9645e;

    /* renamed from: f */
    private String f9646f;

    /* JADX WARN: Type inference failed for: r0v2, types: [Progress, java.lang.Integer] */
    public C2521l(EnumC1399aq enumC1399aq, String str) {
        super(f9642h);
        this.f9643c = new ArrayList();
        this.f9644d = 0;
        this.f12036a = 0;
        this.f9645e = enumC1399aq;
        this.f9646f = str;
    }

    /* renamed from: a */
    public void m9446a(Handler handler) {
        if (!this.f9643c.contains(handler)) {
            this.f9643c.add(handler);
        }
    }

    /* renamed from: b */
    public void m9451b(Handler handler) {
        this.f9643c.remove(handler);
    }

    /* renamed from: a */
    public void m9445a() {
        this.f9643c.clear();
    }

    /* renamed from: b */
    public EnumC1399aq m9449b() {
        return this.f9645e;
    }

    /* renamed from: c */
    public String m9454c() {
        return this.f9646f;
    }

    /* renamed from: d */
    public int m9455d() {
        return this.f9644d;
    }

    @Override // com.sec.common.util.AbstractC3331a
    /* renamed from: e */
    protected void mo9456e() {
        super.mo9456e();
        if (C3250y.f11734b) {
            C3250y.m11450b("InstallAsyncWorker.onPreExecute()", f9640b);
        }
        C2525p.m9458a().m9460a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC3331a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean mo9453c(Params... paramsArr) {
        try {
            if (C3250y.f11734b) {
                C3250y.m11450b("InstallAsyncWorker.onDownloading()", f9640b);
            }
            this.f9644d = 1;
            Message.obtain(f9641g, 1, this).sendToTarget();
            DownloadResult downloadresultMo9434a = mo9434a((Object[]) paramsArr);
            if (C3250y.f11734b) {
                C3250y.m11450b("InstallAsyncWorker.onInstalling()", f9640b);
            }
            this.f9644d = 2;
            Message.obtain(f9641g, 2, this).sendToTarget();
            return mo9433a((C2521l<Params, DownloadResult>) downloadresultMo9434a, (Object[]) paramsArr);
        } catch (C2523n e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9640b);
            }
            return false;
        } catch (InterruptedException e2) {
            if (C3250y.f11736d) {
                C3250y.m11455d("InstallAsyncWorker is interrupted.", f9640b);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC3331a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo9452b(Boolean bool) {
        super.mo9452b((C2521l<Params, DownloadResult>) bool);
        if (C3250y.f11734b) {
            C3250y.m11450b("InstallAsyncWorker.onPostExecute()", f9640b);
        }
        if (bool.booleanValue()) {
            this.f9644d = 4;
            m9443a(4);
            this.f9643c.clear();
            C2525p.m9458a().m9464b(this);
            return;
        }
        this.f9644d = 5;
        m9443a(5);
        C2525p.m9458a().m9467c(this);
    }

    @Override // com.sec.common.util.AbstractC3331a
    /* renamed from: f */
    protected void mo9457f() {
        super.mo9457f();
        if (C3250y.f11734b) {
            C3250y.m11450b("InstallAsyncWorker.onCancelled()", f9640b);
        }
        this.f9644d = 3;
        m9443a(3);
        this.f9643c.clear();
        C2525p.m9458a().m9464b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC3331a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo9448a(Integer num) {
        super.mo9448a((C2521l<Params, DownloadResult>) num);
        Iterator<Handler> it = this.f9643c.iterator();
        while (it.hasNext()) {
            Message.obtain(it.next(), 6, num.intValue(), 0, this).sendToTarget();
        }
    }

    /* renamed from: a */
    protected DownloadResult mo9434a(Params... paramsArr) {
        return null;
    }

    /* renamed from: a */
    protected Boolean mo9433a(DownloadResult downloadresult, Params... paramsArr) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9443a(int i) {
        Iterator<Handler> it = this.f9643c.iterator();
        while (it.hasNext()) {
            Message.obtain(it.next(), i, this).sendToTarget();
        }
    }
}
