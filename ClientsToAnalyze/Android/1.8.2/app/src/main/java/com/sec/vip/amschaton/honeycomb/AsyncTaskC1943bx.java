package com.sec.vip.amschaton.honeycomb;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bx */
/* loaded from: classes.dex */
class AsyncTaskC1943bx extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7087a;

    private AsyncTaskC1943bx(AMSSamplesActivity aMSSamplesActivity) {
        this.f7087a = aMSSamplesActivity;
    }

    /* synthetic */ AsyncTaskC1943bx(AMSSamplesActivity aMSSamplesActivity, C1935bp c1935bp) {
        this(aMSSamplesActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f7087a.m6799m();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C2064n.m7173a().m7186a(this.f7087a.getAssets(), AMSActivity.f6609b, AMSActivity.f6610c)) {
            C1786r.m6054a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f7087a.f7002s.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f7087a.m6800n();
        super.onPostExecute(l);
    }
}
