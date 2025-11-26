package com.sec.vip.amschaton.ics;

import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ap */
/* loaded from: classes.dex */
class AsyncTaskC1993ap extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7267a;

    private AsyncTaskC1993ap(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7267a = aMSMyWorksActivity;
    }

    /* synthetic */ AsyncTaskC1993ap(AMSMyWorksActivity aMSMyWorksActivity, C1986ai c1986ai) {
        this(aMSMyWorksActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f7267a.m7031q();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) {
        if (!C2064n.m7173a().m7186a(this.f7267a.getAssets(), AMSActivity.f6609b, AMSActivity.f6610c)) {
            C1786r.m6054a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f7267a.f7202t.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) {
        this.f7267a.m7032r();
        super.onPostExecute(l);
    }
}
