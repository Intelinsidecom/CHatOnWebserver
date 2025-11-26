package com.sec.chaton.sns.p115ui;

import android.os.AsyncTask;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.o */
/* loaded from: classes.dex */
class AsyncTaskC4493o extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ DialogC4487i f16200a;

    private AsyncTaskC4493o(DialogC4487i dialogC4487i) {
        this.f16200a = dialogC4487i;
    }

    /* synthetic */ AsyncTaskC4493o(DialogC4487i dialogC4487i, DialogInterfaceOnCancelListenerC4488j dialogInterfaceOnCancelListenerC4488j) {
        this(dialogC4487i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        this.f16200a.f16185d.mo2273a(strArr[0]);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r1) {
        super.onPostExecute(r1);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
