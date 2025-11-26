package com.sec.vip.amschaton.ics;

import android.os.AsyncTask;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ax */
/* loaded from: classes.dex */
class AsyncTaskC1493ax extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5312a;

    private AsyncTaskC1493ax(AMSSamplesActivity aMSSamplesActivity) {
        this.f5312a = aMSSamplesActivity;
    }

    /* synthetic */ AsyncTaskC1493ax(AMSSamplesActivity aMSSamplesActivity, C1536r c1536r) {
        this(aMSSamplesActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5312a.m5562n();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C1364aa.m4865a().m4878a(this.f5312a.getAssets(), AMSActivity.f4623e, AMSActivity.f4624f)) {
            C1341p.m4651a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f5312a.f5262r.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f5312a.m5563o();
        super.onPostExecute(l);
    }
}
