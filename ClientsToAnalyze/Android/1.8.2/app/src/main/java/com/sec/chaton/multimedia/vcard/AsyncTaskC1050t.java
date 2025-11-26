package com.sec.chaton.multimedia.vcard;

import android.net.Uri;
import android.os.AsyncTask;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.t */
/* loaded from: classes.dex */
class AsyncTaskC1050t extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f3904a;

    AsyncTaskC1050t(VCardReadContactActivity vCardReadContactActivity) {
        this.f3904a = vCardReadContactActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1038h doInBackground(Uri... uriArr) {
        if (this.f3904a.f3817k != null) {
            return this.f3904a.f3817k.mo3995a(this.f3904a.getContentResolver(), uriArr[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C1038h c1038h) {
        this.f3904a.m4018a(c1038h);
    }
}
