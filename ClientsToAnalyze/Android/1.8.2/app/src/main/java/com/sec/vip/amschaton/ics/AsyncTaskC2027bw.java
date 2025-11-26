package com.sec.vip.amschaton.ics;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bw */
/* loaded from: classes.dex */
class AsyncTaskC2027bw extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7315a;

    private AsyncTaskC2027bw(AMSSamplesActivity aMSSamplesActivity) {
        this.f7315a = aMSSamplesActivity;
    }

    /* synthetic */ AsyncTaskC2027bw(AMSSamplesActivity aMSSamplesActivity, C2020bp c2020bp) {
        this(aMSSamplesActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f7315a.m7119n();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C2064n.m7173a().m7186a(this.f7315a.getAssets(), AMSActivity.f6609b, AMSActivity.f6610c)) {
            C1786r.m6054a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f7315a.f7230r.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f7315a.m7120o();
        super.onPostExecute(l);
    }
}
