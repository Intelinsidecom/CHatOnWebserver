package com.sec.chaton.facebook;

import android.os.AsyncTask;
import com.p001a.p002a.C0036k;
import java.util.Timer;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.j */
/* loaded from: classes.dex */
class AsyncTaskC0729j extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C0725f f2712a;

    /* renamed from: b */
    private int f2713b;

    /* renamed from: c */
    private String f2714c;

    /* renamed from: d */
    private Boolean f2715d;

    /* renamed from: e */
    private Timer f2716e;

    /* synthetic */ AsyncTaskC0729j(C0725f c0725f, int i, HandlerC0726g handlerC0726g) {
        this(c0725f, i);
    }

    private AsyncTaskC0729j(C0725f c0725f, int i) {
        this.f2712a = c0725f;
        this.f2715d = false;
        this.f2716e = null;
        this.f2713b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(AbstractC0728i... abstractC0728iArr) {
        AbstractC0728i abstractC0728i = null;
        int i = 0;
        int iMo3226a = -1;
        while (true) {
            if (i >= abstractC0728iArr.length) {
                break;
            }
            abstractC0728i = abstractC0728iArr[i];
            C0725f.m3213c("Request:" + this.f2713b + " Task : " + abstractC0728i + "\t[" + (i + 1) + "/" + abstractC0728iArr.length + "]");
            m3232a();
            iMo3226a = abstractC0728i.mo3226a();
            m3233b();
            if (iMo3226a != -1) {
                C0725f.m3213c("Result : " + iMo3226a + "\t[" + (i + 1) + "/" + abstractC0728iArr.length + "]");
                break;
            }
            i++;
        }
        if (abstractC0728i == null) {
            return -1000;
        }
        this.f2714c = abstractC0728i.m3228b();
        return Integer.valueOf(iMo3226a);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C0725f.m3213c("Request:" + this.f2713b + " Start.");
        m3232a();
        this.f2712a.f2705e.add(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        this.f2712a.f2705e.remove(this);
        if (num.intValue() <= -1000) {
            C0725f.m3214d("Request:" + this.f2713b + ", Error. " + num + " " + this.f2714c);
            if (num.intValue() == -1001) {
                C0036k.m29a(this.f2712a.f2703c);
                C0725f.f2701b.m14a((String) null);
                C0725f.f2701b.m9a(0L);
            }
        } else {
            C0725f.m3213c("Request:" + this.f2713b + " Done. " + num + " " + this.f2714c);
        }
        this.f2712a.f2704d.mo3203a(this.f2713b, num.intValue(), this.f2714c);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        m3233b();
        synchronized (this.f2715d) {
            if (this.f2715d.booleanValue()) {
                C0725f.m3214d("onError()");
                this.f2712a.f2704d.mo3203a(this.f2713b, -1000, null);
            } else {
                C0725f.m3213c("Request:" + this.f2713b + " Canceled.");
                this.f2712a.f2704d.mo3203a(this.f2713b, 0, null);
            }
            this.f2715d = false;
        }
    }

    /* renamed from: a */
    private void m3232a() {
        C0730k c0730k = new C0730k(this);
        m3233b();
        C0725f.m3214d("startTimeOutCheckTask()");
        this.f2716e = new Timer();
        this.f2716e.schedule(c0730k, 30000L);
    }

    /* renamed from: b */
    private void m3233b() {
        if (this.f2716e != null) {
            C0725f.m3214d("cancelTimeOutCheckTask()");
            this.f2716e.cancel();
            this.f2716e = null;
        }
    }
}
