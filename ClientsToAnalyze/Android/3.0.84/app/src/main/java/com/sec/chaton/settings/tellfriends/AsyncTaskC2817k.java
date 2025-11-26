package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.k */
/* loaded from: classes.dex */
class AsyncTaskC2817k extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ DialogC2811e f10342a;

    private AsyncTaskC2817k(DialogC2811e dialogC2811e) {
        this.f10342a = dialogC2811e;
    }

    /* synthetic */ AsyncTaskC2817k(DialogC2811e dialogC2811e, DialogInterfaceOnCancelListenerC2812f dialogInterfaceOnCancelListenerC2812f) {
        this(dialogC2811e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        this.f10342a.f10327d.mo541a(strArr[0]);
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
