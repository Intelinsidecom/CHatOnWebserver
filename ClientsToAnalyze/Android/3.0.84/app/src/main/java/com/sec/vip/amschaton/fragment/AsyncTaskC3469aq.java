package com.sec.vip.amschaton.fragment;

import android.os.AsyncTask;
import com.sec.vip.amschaton.AMSActivity;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.aq */
/* loaded from: classes.dex */
class AsyncTaskC3469aq extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12831a;

    private AsyncTaskC3469aq(AMSComposerFragment aMSComposerFragment) {
        this.f12831a = aMSComposerFragment;
    }

    /* synthetic */ AsyncTaskC3469aq(AMSComposerFragment aMSComposerFragment, C3453aa c3453aa) {
        this(aMSComposerFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        if (!this.f12831a.m12457d(false)) {
            this.f12831a.f12682ad = false;
            return false;
        }
        this.f12831a.f12695c = AMSActivity.f12274g;
        if (!this.f12831a.f12675W) {
            this.f12831a.f12695c = this.f12831a.f12673U;
        }
        AMSComposerFragment.f12651a = false;
        this.f12831a.m12418C();
        return true;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f12831a.m12507u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        this.f12831a.m12509v();
        if (bool.booleanValue() && this.f12831a.getActivity() != null && !this.f12831a.getActivity().isFinishing()) {
            this.f12831a.m12528b(this.f12831a.f12695c, 2001);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f12831a.f12682ad = false;
        this.f12831a.m12509v();
    }
}
