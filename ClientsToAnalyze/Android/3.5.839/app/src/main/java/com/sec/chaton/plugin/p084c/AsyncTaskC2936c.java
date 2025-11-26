package com.sec.chaton.plugin.p084c;

import com.sec.chaton.smsplugin.provider.AsyncTaskC3948f;

/* compiled from: SMSUtils.java */
/* renamed from: com.sec.chaton.plugin.c.c */
/* loaded from: classes.dex */
class AsyncTaskC2936c extends AsyncTaskC3948f {

    /* renamed from: a */
    final /* synthetic */ C2934a f10827a;

    AsyncTaskC2936c(C2934a c2934a) {
        this.f10827a = c2934a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (this.f10827a.f10824d != null) {
            this.f10827a.f10824d.sendEmptyMessage(3);
        }
        super.onPostExecute(num);
    }
}
