package com.sec.vip.amschaton.fragment;

import android.os.AsyncTask;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ar */
/* loaded from: classes.dex */
class AsyncTaskC3470ar extends AsyncTask<Boolean, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12832a;

    private AsyncTaskC3470ar(AMSComposerFragment aMSComposerFragment) {
        this.f12832a = aMSComposerFragment;
    }

    /* synthetic */ AsyncTaskC3470ar(AMSComposerFragment aMSComposerFragment, C3453aa c3453aa) {
        this(aMSComposerFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f12832a.f12686ah = true;
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Boolean... boolArr) {
        this.f12832a.f12686ah = true;
        if (boolArr[0].booleanValue()) {
            this.f12832a.f12694ap.sendEmptyMessage(1);
            return null;
        }
        this.f12832a.f12694ap.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        this.f12832a.f12686ah = false;
        super.onPostExecute(r3);
    }
}
