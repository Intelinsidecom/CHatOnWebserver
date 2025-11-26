package com.sec.chaton.multimedia.vcard;

import android.net.Uri;
import android.os.AsyncTask;

/* renamed from: com.sec.chaton.multimedia.vcard.h */
/* loaded from: classes.dex */
class AsyncTaskC0324h extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f2384a;

    AsyncTaskC0324h(VCardReadContactActivity vCardReadContactActivity) {
        this.f2384a = vCardReadContactActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContactStruct doInBackground(Uri... uriArr) {
        return this.f2384a.f2355j.mo2614a(this.f2384a.getContentResolver(), uriArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ContactStruct contactStruct) {
        this.f2384a.m2658a(contactStruct);
    }
}
