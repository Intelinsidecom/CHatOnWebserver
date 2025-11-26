package com.sec.chaton.account;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: ChatONAccountService.java */
/* renamed from: com.sec.chaton.account.f */
/* loaded from: classes.dex */
class AsyncTaskC0420f extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC0417c f1474a;

    private AsyncTaskC0420f(ServiceConnectionC0417c serviceConnectionC0417c) {
        this.f1474a = serviceConnectionC0417c;
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
        if (this.f1474a.f1467c != null) {
            C3641ai.m13210a(this.f1474a.f1467c, R.string.trunk_network_not_available, 0).show();
        }
    }
}
