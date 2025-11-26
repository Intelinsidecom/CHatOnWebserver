package com.sec.chaton.multimedia.vcard;

import android.net.Uri;
import android.os.AsyncTask;

/* compiled from: VCardReadContactFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcard.q */
/* loaded from: classes.dex */
class AsyncTaskC1943q extends AsyncTask<Uri, Void, C1928b> {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactFragment f7457a;

    AsyncTaskC1943q(VCardReadContactFragment vCardReadContactFragment) {
        this.f7457a = vCardReadContactFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1928b doInBackground(Uri... uriArr) {
        return this.f7457a.f7376b.mo7832a(this.f7457a.getActivity().getContentResolver(), uriArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C1928b c1928b) {
        this.f7457a.m7861a(c1928b);
    }
}
