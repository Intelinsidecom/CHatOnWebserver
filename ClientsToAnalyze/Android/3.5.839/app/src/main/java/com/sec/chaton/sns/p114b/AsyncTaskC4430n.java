package com.sec.chaton.sns.p114b;

import android.os.AsyncTask;
import com.sec.chaton.sns.p115ui.odnoklassniki.p116a.C4495a;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.List;

/* compiled from: OdnoklassnikiManager.java */
/* renamed from: com.sec.chaton.sns.b.n */
/* loaded from: classes.dex */
class AsyncTaskC4430n extends AsyncTask<String, Void, List<C4495a>> {

    /* renamed from: a */
    final /* synthetic */ C4427k f15997a;

    /* renamed from: b */
    private int f15998b;

    protected AsyncTaskC4430n(C4427k c4427k, int i) {
        this.f15997a = c4427k;
        this.f15998b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C4495a> doInBackground(String... strArr) {
        return this.f15997a.m16775e(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C4495a> list) {
        if (list == null || list.size() < 0) {
            this.f15997a.f15991h.mo16563a(this.f15998b, DlcApi.RC_SVC_NOT_CONNECTED, null);
        } else {
            this.f15997a.f15991h.mo16563a(this.f15998b, -1, list);
        }
    }
}
