package com.sec.chaton.multimedia.vcard;

import android.net.Uri;
import android.os.AsyncTask;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.m */
/* loaded from: classes.dex */
class AsyncTaskC0836m extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f2916a;

    AsyncTaskC0836m(VCardReadContactActivity vCardReadContactActivity) {
        this.f2916a = vCardReadContactActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0833j doInBackground(Uri... uriArr) {
        return this.f2916a.f2845j.mo3356a(this.f2916a.getContentResolver(), uriArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0833j c0833j) {
        this.f2916a.m3382a(c0833j);
    }
}
