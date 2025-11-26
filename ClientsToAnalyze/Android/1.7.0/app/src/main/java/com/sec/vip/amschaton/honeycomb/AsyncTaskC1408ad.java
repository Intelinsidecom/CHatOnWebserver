package com.sec.vip.amschaton.honeycomb;

import android.os.AsyncTask;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ad */
/* loaded from: classes.dex */
class AsyncTaskC1408ad extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5036a;

    private AsyncTaskC1408ad(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5036a = aMSMyWorksActivity;
    }

    /* synthetic */ AsyncTaskC1408ad(AMSMyWorksActivity aMSMyWorksActivity, C1457p c1457p) {
        this(aMSMyWorksActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5036a.m5150n();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C1364aa.m4865a().m4878a(this.f5036a.getAssets(), AMSActivity.f4623e, AMSActivity.f4624f)) {
            C1341p.m4651a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f5036a.f4987u.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f5036a.m5151o();
        super.onPostExecute(l);
    }
}
