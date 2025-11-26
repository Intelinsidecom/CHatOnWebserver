package com.sec.vip.amschaton.honeycomb;

import android.os.AsyncTask;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.i */
/* loaded from: classes.dex */
class AsyncTaskC1450i extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5089a;

    private AsyncTaskC1450i(AMSSamplesActivity aMSSamplesActivity) {
        this.f5089a = aMSSamplesActivity;
    }

    /* synthetic */ AsyncTaskC1450i(AMSSamplesActivity aMSSamplesActivity, C1430az c1430az) {
        this(aMSSamplesActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5089a.m5233m();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C1364aa.m4865a().m4878a(this.f5089a.getAssets(), AMSActivity.f4623e, AMSActivity.f4624f)) {
            C1341p.m4651a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f5089a.f5017q.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f5089a.m5234n();
        super.onPostExecute(l);
    }
}
