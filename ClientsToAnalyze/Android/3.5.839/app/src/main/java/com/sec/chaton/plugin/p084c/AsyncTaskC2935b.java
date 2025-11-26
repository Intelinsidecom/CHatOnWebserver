package com.sec.chaton.plugin.p084c;

import com.sec.chaton.smsplugin.provider.AsyncTaskC3949g;

/* compiled from: SMSUtils.java */
/* renamed from: com.sec.chaton.plugin.c.b */
/* loaded from: classes.dex */
class AsyncTaskC2935b extends AsyncTaskC3949g {

    /* renamed from: a */
    final /* synthetic */ C2934a f10826a;

    AsyncTaskC2935b(C2934a c2934a) {
        this.f10826a = c2934a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (this.f10826a.f10824d != null) {
            this.f10826a.f10824d.sendEmptyMessage(3);
        }
        super.onPostExecute(num);
    }
}
