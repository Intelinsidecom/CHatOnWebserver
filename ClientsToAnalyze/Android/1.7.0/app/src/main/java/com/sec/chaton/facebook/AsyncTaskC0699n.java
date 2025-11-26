package com.sec.chaton.facebook;

import android.os.AsyncTask;
import com.p001a.p002a.C0037b;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.n */
/* loaded from: classes.dex */
class AsyncTaskC0699n extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C0700o f2372a;

    /* renamed from: b */
    private int f2373b;

    /* renamed from: c */
    private String f2374c;

    private AsyncTaskC0699n(C0700o c0700o, int i) {
        this.f2372a = c0700o;
        this.f2373b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(AbstractC0701p... abstractC0701pArr) {
        AbstractC0701p abstractC0701p = null;
        int iMo3065a = -1;
        for (int i = 0; i < abstractC0701pArr.length; i++) {
            abstractC0701p = abstractC0701pArr[i];
            iMo3065a = abstractC0701p.mo3065a();
            C0700o.m3078c("Request:" + this.f2373b + " Task : " + abstractC0701p);
            if (iMo3065a != -1) {
                break;
            }
        }
        if (abstractC0701p == null) {
            return -1000;
        }
        this.f2374c = abstractC0701p.m3087b();
        return Integer.valueOf(iMo3065a);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C0700o.m3078c("Request:" + this.f2373b + " Start.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (num.intValue() <= -1000) {
            C0700o.m3079d("Request:" + this.f2373b + ", Error. " + num + " " + this.f2374c);
            if (num.intValue() == -1001) {
                C0037b.m10a(this.f2372a.f2376b);
                C0700o.f2375a.m31a((String) null);
                C0700o.f2375a.m27a(0L);
            }
        } else {
            C0700o.m3078c("Request:" + this.f2373b + " Done. " + num + " " + this.f2374c);
        }
        this.f2372a.f2377c.mo3066a(this.f2373b, num.intValue(), this.f2374c);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        C0700o.m3078c("Request:" + this.f2373b + " Canceled.");
        this.f2372a.f2377c.mo3066a(this.f2373b, 0, null);
    }
}
