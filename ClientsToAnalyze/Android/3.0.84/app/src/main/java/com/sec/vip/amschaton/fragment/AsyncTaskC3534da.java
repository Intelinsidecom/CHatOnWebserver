package com.sec.vip.amschaton.fragment;

import android.os.AsyncTask;
import com.sec.vip.amschaton.C3410al;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.da */
/* loaded from: classes.dex */
class AsyncTaskC3534da extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12956a;

    private AsyncTaskC3534da(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12956a = aMSStampSelectionFragment;
    }

    /* synthetic */ AsyncTaskC3534da(AMSStampSelectionFragment aMSStampSelectionFragment, DialogInterfaceOnClickListenerC3507ca dialogInterfaceOnClickListenerC3507ca) {
        this(aMSStampSelectionFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f12956a.m12653q();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        C3410al.m12173a().m12182a(this.f12956a.getActivity());
        this.f12956a.f12749D.sendEmptyMessage(0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        this.f12956a.m12656r();
        super.onPostExecute(r2);
    }
}
