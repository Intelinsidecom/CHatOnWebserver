package com.sec.vip.amschaton.honeycomb;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aq */
/* loaded from: classes.dex */
class AsyncTaskC1909aq extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7039a;

    private AsyncTaskC1909aq(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7039a = aMSMyWorksActivity;
    }

    /* synthetic */ AsyncTaskC1909aq(AMSMyWorksActivity aMSMyWorksActivity, C1894ab c1894ab) {
        this(aMSMyWorksActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f7039a.m6706t();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C2064n.m7173a().m7186a(this.f7039a.getAssets(), AMSActivity.f6609b, AMSActivity.f6610c)) {
            C1786r.m6054a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f7039a.f6971u.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f7039a.m6707u();
        super.onPostExecute(l);
    }
}
