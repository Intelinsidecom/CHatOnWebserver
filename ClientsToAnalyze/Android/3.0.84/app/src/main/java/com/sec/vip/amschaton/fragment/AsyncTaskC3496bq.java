package com.sec.vip.amschaton.fragment;

import android.os.AsyncTask;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.C3584q;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bq */
/* loaded from: classes.dex */
class AsyncTaskC3496bq extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12876a;

    private AsyncTaskC3496bq(AMSListFragment aMSListFragment) {
        this.f12876a = aMSListFragment;
    }

    /* synthetic */ AsyncTaskC3496bq(AMSListFragment aMSListFragment, DialogInterfaceOnClickListenerC3475aw dialogInterfaceOnClickListenerC3475aw) {
        this(aMSListFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f12876a.m12560e();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (!C3584q.m12778a().m12795a(this.f12876a.getActivity())) {
            C3250y.m11442a("AMS file loading has failed!", getClass().getSimpleName());
        }
        this.f12876a.f12725D.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        this.f12876a.m12564f();
        super.onPostExecute(r2);
    }
}
