package com.sec.vip.amschaton.honeycomb;

import android.os.AsyncTask;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aa */
/* loaded from: classes.dex */
class AsyncTaskC1893aa extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7019a;

    private AsyncTaskC1893aa(AMSComposerActivity aMSComposerActivity) {
        this.f7019a = aMSComposerActivity;
    }

    /* synthetic */ AsyncTaskC1893aa(AMSComposerActivity aMSComposerActivity, DialogInterfaceOnClickListenerC1954e dialogInterfaceOnClickListenerC1954e) {
        this(aMSComposerActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f7019a.f6944ag = true;
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Boolean... boolArr) {
        this.f7019a.f6944ag = true;
        if (boolArr[0].booleanValue()) {
            this.f7019a.f6948ak.sendEmptyMessage(1);
            return null;
        }
        this.f7019a.f6948ak.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        this.f7019a.f6944ag = false;
        super.onPostExecute(r3);
    }
}
