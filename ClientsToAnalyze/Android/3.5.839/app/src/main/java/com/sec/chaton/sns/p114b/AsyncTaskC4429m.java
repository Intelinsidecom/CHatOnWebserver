package com.sec.chaton.sns.p114b;

import android.os.AsyncTask;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: OdnoklassnikiManager.java */
/* renamed from: com.sec.chaton.sns.b.m */
/* loaded from: classes.dex */
public final class AsyncTaskC4429m extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ C4427k f15995a;

    /* renamed from: b */
    private int f15996b;

    protected AsyncTaskC4429m(C4427k c4427k, int i) {
        this.f15995a = c4427k;
        this.f15996b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        return this.f15995a.m16781i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if ("NeedUserLoginAgain".equals(str)) {
            this.f15995a.f15991h.mo16563a(this.f15996b, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
        } else {
            new AsyncTaskC4430n(this.f15995a, this.f15996b).execute(str);
        }
    }
}
