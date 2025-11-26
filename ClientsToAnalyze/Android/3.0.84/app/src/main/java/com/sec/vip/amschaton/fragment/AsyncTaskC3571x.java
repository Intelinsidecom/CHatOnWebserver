package com.sec.vip.amschaton.fragment;

import android.os.AsyncTask;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.C3425b;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.x */
/* loaded from: classes.dex */
class AsyncTaskC3571x extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f13020a;

    private AsyncTaskC3571x(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f13020a = aMSBgSelectionFragment;
    }

    /* synthetic */ AsyncTaskC3571x(AMSBgSelectionFragment aMSBgSelectionFragment, ViewOnClickListenerC3452a viewOnClickListenerC3452a) {
        this(aMSBgSelectionFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f13020a.m12405l();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        if (!C3425b.m12268a().m12281a(this.f13020a.getActivity())) {
            C3250y.m11442a("AMS file loading has failed!", getClass().getSimpleName());
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        if (this.f13020a.f12646v != 3002) {
            this.f13020a.m12397h(this.f13020a.f12645u);
        }
        this.f13020a.f12647w = false;
        this.f13020a.m12407m();
        super.onPostExecute(r3);
    }
}
