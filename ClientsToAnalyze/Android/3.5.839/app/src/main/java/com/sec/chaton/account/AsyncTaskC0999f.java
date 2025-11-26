package com.sec.chaton.account;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.f */
/* loaded from: classes.dex */
class AsyncTaskC0999f extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0996c f3264a;

    private AsyncTaskC0999f(ServiceConnectionC0996c serviceConnectionC0996c) {
        this.f3264a = serviceConnectionC0996c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        return null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f3264a.f3257c != null) {
            C5179v.m19810a(this.f3264a.f3257c, R.string.trunk_network_not_available, 0).show();
        }
    }
}
