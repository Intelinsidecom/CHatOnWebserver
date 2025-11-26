package com.sec.chaton.multimedia.vcard;

import android.net.Uri;
import android.os.AsyncTask;

/* compiled from: VCardReadContactFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcard.q */
/* loaded from: classes.dex */
class AsyncTaskC2912q extends AsyncTask<Uri, Void, C2897b> {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactFragment f10778a;

    AsyncTaskC2912q(VCardReadContactFragment vCardReadContactFragment) {
        this.f10778a = vCardReadContactFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2897b doInBackground(Uri... uriArr) {
        if (this.f10778a.f10697j == null || this.f10778a.getActivity() == null || uriArr == null || uriArr[0] == null) {
            return null;
        }
        return this.f10778a.f10697j.mo12061a(this.f10778a.getActivity().getContentResolver(), uriArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C2897b c2897b) {
        if (c2897b != null) {
            this.f10778a.m12087a(c2897b);
        }
    }
}
