package com.sec.vip.amschaton.ics;

import android.os.AsyncTask;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ay */
/* loaded from: classes.dex */
class AsyncTaskC1494ay extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5313a;

    private AsyncTaskC1494ay(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5313a = aMSMyWorksActivity;
    }

    /* synthetic */ AsyncTaskC1494ay(AMSMyWorksActivity aMSMyWorksActivity, C1486aq c1486aq) {
        this(aMSMyWorksActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5313a.m5472t();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C1364aa.m4865a().m4878a(this.f5313a.getAssets(), AMSActivity.f4623e, AMSActivity.f4624f)) {
            C1341p.m4651a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f5313a.f5233t.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f5313a.m5473u();
        super.onPostExecute(l);
    }
}
