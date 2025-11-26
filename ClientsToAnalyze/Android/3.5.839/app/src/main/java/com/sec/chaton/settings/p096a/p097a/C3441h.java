package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.AbstractC5016a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: InstallAsyncWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.h */
/* loaded from: classes.dex */
public class C3441h<Params, DownloadResult> extends AbstractC5016a<Params, Integer, Boolean> {

    /* renamed from: a */
    private static final String f12872a = C3441h.class.getSimpleName();

    /* renamed from: g */
    private static HandlerC3444k f12873g = new HandlerC3444k();

    /* renamed from: h */
    private static final ExecutorService f12874h = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private List<Handler> f12875b;

    /* renamed from: c */
    private int f12876c;

    /* renamed from: d */
    private EnumC2258bd f12877d;

    /* renamed from: f */
    private String f12878f;

    /* JADX WARN: Type inference failed for: r0v2, types: [Progress, java.lang.Integer] */
    public C3441h(EnumC2258bd enumC2258bd, String str) {
        super(f12874h);
        this.f12875b = new ArrayList();
        this.f12876c = 0;
        this.f18303e = 0;
        this.f12877d = enumC2258bd;
        this.f12878f = str;
    }

    /* renamed from: a */
    public void m13716a(Handler handler) {
        if (!this.f12875b.contains(handler)) {
            this.f12875b.add(handler);
        }
    }

    /* renamed from: c */
    public EnumC2258bd m13718c() {
        return this.f12877d;
    }

    /* renamed from: d */
    public String m13720d() {
        return this.f12878f;
    }

    /* renamed from: e */
    public int m13721e() {
        return this.f12876c;
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a */
    protected void mo6107a() {
        super.mo6107a();
        if (C4904y.f17872b) {
            C4904y.m18639b("InstallAsyncWorker.onPreExecute()", f12872a);
        }
        C3445l.m13723a().m13725a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean mo6106a(Params... paramsArr) {
        try {
            if (C4904y.f17872b) {
                C4904y.m18639b("InstallAsyncWorker.onDownloading()", f12872a);
            }
            this.f12876c = 1;
            Message.obtain(f12873g, 1, this).sendToTarget();
            DownloadResult downloadresultMo13705b = mo13705b((Object[]) paramsArr);
            if (C4904y.f17872b) {
                C4904y.m18639b("InstallAsyncWorker.onInstalling()", f12872a);
            }
            this.f12876c = 2;
            Message.obtain(f12873g, 2, this).sendToTarget();
            return mo13703a((C3441h<Params, DownloadResult>) downloadresultMo13705b, (Object[]) paramsArr);
        } catch (C3443j e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12872a);
            }
            return false;
        } catch (InterruptedException e2) {
            if (C4904y.f17874d) {
                C4904y.m18645d("InstallAsyncWorker is interrupted.", f12872a);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo6108a(Boolean bool) {
        super.mo6108a((C3441h<Params, DownloadResult>) bool);
        if (C4904y.f17872b) {
            C4904y.m18639b("InstallAsyncWorker.onPostExecute()", f12872a);
        }
        if (bool.booleanValue()) {
            this.f12876c = 4;
            m13714a(4);
            this.f12875b.clear();
            C3445l.m13723a().m13726b(this);
            return;
        }
        this.f12876c = 5;
        m13714a(5);
        C3445l.m13723a().m13727c(this);
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: b */
    protected void mo6109b() {
        super.mo6109b();
        if (C4904y.f17872b) {
            C4904y.m18639b("InstallAsyncWorker.onCancelled()", f12872a);
        }
        this.f12876c = 3;
        m13714a(3);
        this.f12875b.clear();
        C3445l.m13723a().m13726b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo7398b(Integer num) {
        super.mo7398b((C3441h<Params, DownloadResult>) num);
        Iterator<Handler> it = this.f12875b.iterator();
        while (it.hasNext()) {
            Message.obtain(it.next(), 6, num.intValue(), 0, this).sendToTarget();
        }
    }

    /* renamed from: b */
    protected DownloadResult mo13705b(Params... paramsArr) {
        return null;
    }

    /* renamed from: a */
    protected Boolean mo13703a(DownloadResult downloadresult, Params... paramsArr) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13714a(int i) {
        Iterator<Handler> it = this.f12875b.iterator();
        while (it.hasNext()) {
            Message.obtain(it.next(), i, this).sendToTarget();
        }
    }
}
